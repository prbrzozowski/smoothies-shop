import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnDestroy, OnInit} from "@angular/core";
import {BusinessOwnerService} from "../services/businessowner.service";
import {first, Subscription} from "rxjs";
import {SmoothieDto} from "../../../../../target/generated-sources/smoothies-api";
import {LazyLoadEvent} from "primeng/api";
import {Pagination, SmoothiesLoadState} from "../state/businessowner.state";

@Component({
  selector: 'smoothies-list',
  templateUrl: './smooties-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SmootiesListComponent implements OnInit, OnDestroy {
  private subscriptionStub: Subscription = new Subscription();
  smoothies: SmoothieDto[] = [];
  smoothiesLoadState: SmoothiesLoadState = SmoothiesLoadState.BEING_LOADED;

  first: number = 0;
  rows: number = 0;
  totalSmoothiesCount: number = 0;

  constructor(private readonly businessOwnerService: BusinessOwnerService,
              private readonly changeDetectorRef: ChangeDetectorRef) {

  }

  ngOnInit(): void {
    this.subscriptionStub.add(
      this.businessOwnerService.getPagination()
        .pipe(first())
        .subscribe(pagination => {
          this.first = pagination.page;
          this.rows = pagination.pageSize;
          this.changeDetectorRef.detectChanges();
        }));
    this.subscriptionStub.add(
      this.businessOwnerService.getSmoothies()
        .subscribe(smoothies => {
          this.smoothies = smoothies;
          this.changeDetectorRef.detectChanges();
        })
    );
    this.subscriptionStub.add(
      this.businessOwnerService.getSmoothiesLoadState()
        .subscribe(smoothiesLoadState => {
          this.smoothiesLoadState = smoothiesLoadState;
          this.changeDetectorRef.detectChanges();
        })
    );
    this.subscriptionStub.add(
      this.businessOwnerService.getTotalSmoothiesCount()
        .subscribe(totalSmoothiesCount => {
          this.totalSmoothiesCount = totalSmoothiesCount;
          this.changeDetectorRef.detectChanges();
        }));
  }

  loadSmoothies($event: LazyLoadEvent) {
    const first = $event.first ?? this.first;
    const rows = $event.rows ?? this.rows;
    const pagination: Pagination = {
      page: first / rows,
      pageSize: rows
    };
    this.businessOwnerService.paginationChanged(pagination);
    this.businessOwnerService.loadSmoothies(pagination);
  }

  smoothiesBeingLoaded(): boolean {
    return this.smoothiesLoadState === SmoothiesLoadState.BEING_LOADED;
  }

  ngOnDestroy(): void {
    this.subscriptionStub.unsubscribe();
  }

}
