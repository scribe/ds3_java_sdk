#!/bin/bash
echo Using Git Repo: ${GIT_REPO:="git@github.com:SpectraLogic/escape_pod.git"}
echo Using Git Branch: ${GIT_BRANCH:="master"}

echo DS3_ENDPOINT ${DS3_ENDPOINT}
echo DS3_SECRET_KEY ${DS3_SECRET_KEY}
echo DS3_ACCESS_KEY ${DS3_ACCESS_KEY}

set -x

cd /opt

if [ ${GIT_BRANCH} != "master" ]; then
  git clone ${GIT_REPO} --branch ${GIT_BRANCH} --single-branch
else
  git clone ${GIT_REPO}
fi

cd escape_pod
git rev-parse HEAD

./gradlew jar unit

