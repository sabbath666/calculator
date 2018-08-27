#!/bin/bash
sleep 30
test $(curl http://142.93.73.34:8888/sum?a=1\&b=2) -eq 3
