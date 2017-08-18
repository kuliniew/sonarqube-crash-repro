This reproduces a bug that causes SonarQube to crash when analyzing a Java app.

This was tested with:

* 64-bit Linux
* SonarQube 6.5 (server)
* sonar-scanner-cli 3.0.3.778 (client)

## Steps to reproduce

1. Start SonarQube
2. If `sonar-scanner` is not on your `PATH`, set `SONAR_SCANNER` to the location of the `sonar-scanner` binary
3. Run `make`

Analysis will fail with a `StackOverflowError` from the `org.sonar.java.resolve.TypeInferenceSolver` class.

## Workaround

Changing `new Apple.Builder<>()` to `new Apple.Builder<E>()` on line 12 of `repro/Repro.java` makes the problem
go away.  However, your Java compiler or IDE might start warning that the `E` is unnecessary because it can be
deduced by type inference.  Which it should be, if not for the bug in SonarQube.

## Notes

This reproducer was derived from real-world code, but all the irrelevant stuff has been removed and some of the
identifiers changed to protect the innocent.
