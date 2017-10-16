#!/bin/bash
docker run -v /home/spectra/.ssh/id_rsa:/tmp/id_rsa:ro spectralogic/escape_pod_unit_tests:latest
