#!/bin/bash
echo Using Git Repo: ${GIT_REPO:="git@github.com:SpectraLogic/escape_pod.git"}

set -x

cd /opt
ssh-agent bash -c "ssh-add /tmp/id_rsa; ssh-keyscan -t rsa github.com >> ~/.ssh/known_hosts; yes | git clone ${GIT_REPO}"

cd escape_pod
git rev-parse HEAD

./gradlew jar unit

