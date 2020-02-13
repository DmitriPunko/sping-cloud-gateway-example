Example reproducing 200 OK HTTP Response status inside GlobalFilter when SSLEngine problem exception occurred.

Created test route that generate General SSLEngine problem exception.
After chain filter execution getting 200 OK status and logging it.
Expecting to get same status as came with response(500 inside filter and 500 status with response from gateway)