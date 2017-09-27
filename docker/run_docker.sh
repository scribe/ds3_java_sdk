#!/bin/bash
docker run -it -v ~/.ssh/id_rsa_github:/root/.ssh/id_rsa_github:ro escape_pod_unit_tests:latest
