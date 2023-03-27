# smoothies-shop

TODO

1. Implement exception handler for the exceptions thrown from thecontrollers
2. The detailed exception stacktraces should be put in the log.
3. Any information about the stacktrace must not be passed out to the world.
4. The database key ids should not be used at the endpoints parameters or bodies. An unguessable id should be used for that.
5. Swagger file should be get generated automatically, packed in an versionable artifact. 
6. Then artifact should be unpacked during FE building and used for generating open-api typescript.
7. Unit tests (spock or junit)
8. Proper error handling at FE.
9. Security enforcements - right now it is a simple CORS bypass by hardcoding Access-Control-Allow-Origin to http://localhost:4200
10. Maaaany others
