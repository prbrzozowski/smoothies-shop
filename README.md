# smoothies-shop

TODO

1. Implement exception handler for the exceptions thrown from controllers
2. The exceptions should be put in the log.
3. Any information about the stacktrace must not be passed out to the world.
4. The database key ids should not be used in the endpoints parameters or bodies.
   For update and deletion a kind of unique fingerprint id should be used.
5. Swagger file should be generated, packed in an artifact.
6. Then artifact should be unpacked during FE building and used for open-api typescript client.
