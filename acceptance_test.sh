#!/bin/bash
sleep 60
test $(curl calculator:8888/sum?a=1\&b=2) -eq 3
