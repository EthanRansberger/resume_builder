@echo off
setlocal

REM Replace these variables with your repository details
set REPO_OWNER=your-github-username
set REPO_NAME=resume-builder

REM Get the latest release information
curl -s https://api.github.com/repos/%REPO_OWNER%/%REPO_NAME%/releases/latest > latest_release.json

REM Extract the download URLs for JAR and EXE
for /f "tokens=2 delims=: " %%i in ('findstr /i "browser_download_url" latest_release.json ^| findstr /i "resume-builder-1.0-SNAPSHOT.jar"') do set JAR_URL=%%i
for /f "tokens=2 delims=: " %%i in ('findstr /i "browser_download_url" latest_release.json ^| findstr /i "resume-builder.exe"') do set EXE_URL=%%i

REM Remove quotes from URLs
set JAR_URL=%JAR_URL:"=%
set EXE_URL=%EXE_URL:"=%

REM Download the JAR and EXE files
curl -L -o resume-builder-1.0-SNAPSHOT.jar %JAR_URL%
curl -L -o resume-builder.exe %EXE_URL%

REM Run the EXE file
start resume-builder.exe

endlocal
