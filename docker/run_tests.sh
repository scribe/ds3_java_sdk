#!/bin/bash
echo Using Git Repo: ${GIT_REPO:="git@github.com:SpectraLogic/escape_pod.git"}

set -x

cd /opt
ssh-agent bash -c "ssh-add ~/.ssh/id_rsa_github; git clone ${GIT_REPO}"

cd escape_pod
git rev-parse HEAD

./gradlew jar unit

