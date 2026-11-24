@echo off
REM Windows: run this inside the ResuMatchSimple folder.
REM To use Gemini, run this first (once per terminal):   set GEMINI_API_KEY=your-key-here
if not exist out mkdir out
javac -d out src\resumatch\*.java
java -cp out resumatch.Main
