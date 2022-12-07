#!/usr/bin/env bash

USER="admin"
PASSWORD="admin"
BUILD_DIR="$PWD"
TARGET_PATH="src/test/resources/features"
ZIP_FILE="bddfile.zip"

JIRA_URL="http://ruta:puerto"
PROJECT_KEY="KEY"

echo "Clean target path"
rm -rf $BUILD_DIR/$TARGET_PATH
mkdir -p $BUILD_DIR/$TARGET_PATH

echo "Downloading feature files"
curl -u $USER:$PASSWORD $JIRA_URL/jira/rest/atm/1.0/automation/testcases?tql="testCase.projectKey='$PROJECT_KEY'" --output $BUILD_DIR/$TARGET_PATH/$ZIP_FILE

echo "Unzipping feature files"
unzip $BUILD_DIR/$TARGET_PATH/$ZIP_FILE -d $BUILD_DIR/$TARGET_PATH
echo "Finished"