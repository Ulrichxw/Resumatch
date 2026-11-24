#!/bin/sh
# Mac/Linux: run  sh run.sh  inside the ResuMatchSimple folder.
# To use Gemini, run this first (once per terminal):   export GEMINI_API_KEY=your-key-here
mkdir -p out
javac -d out src/resumatch/*.java && java -cp out resumatch.Main
