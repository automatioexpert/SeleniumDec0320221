#!/usr/bin/env bash
kill -9 $(lsof -t -i:4723)
appium -a localhost --port 4723 --nodeconfig $(pwd)/appiumNodeConfig.json --chromedriver-executable $(pwd)/src/main/resources/drivers/chromedriver-mac-83
