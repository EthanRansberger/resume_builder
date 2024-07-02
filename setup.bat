@echo off
setlocal enabledelayedexpansion

REM Replace these variables with your repository details
set REPO_OWNER=your-github-username
set REPO_NAME=resume-builder

REM Get the latest release information
curl -s https://api.github.com/repos/%REPO_OWNER%/%REPO_NAME%/releases/latest > latest_release.json

REM Extract the download URLs for JAR and EXE
set "JAR_URL="
set "EXE_URL="

for /f "tokens=2 delims=:" %%i in ('findstr /i "browser_download_url" latest_release.json ^| findstr /i "resume-builder-1.0-SNAPSHOT.jar"') do (
    set "JAR_URL=%%i"
)
for /f "tokens=2 delims=:" %%i in ('findstr /i "browser_download_url" latest_release.json ^| findstr /i "resume-builder.exe"') do (
    set "EXE_URL=%%i"
)

REM Remove quotes and commas from URLs
set "JAR_URL=!JAR_URL:~2,-1!"
set "EXE_URL=!EXE_URL:~2,-1!"

REM Trim leading and trailing spaces (if any)
set "JAR_URL=!JAR_URL: =!"
set "EXE_URL=!EXE_URL: =!"

REM Check if URLs were found
if "%JAR_URL%"=="" (
    echo Failed to find JAR URL in the release.
    exit /b 1
)
if "%EXE_URL%"=="" (
    echo Failed to find EXE URL in the release.
    exit /b 1
)

REM Download the JAR and EXE files
curl -L -o resume-builder-1.0-SNAPSHOT.jar %JAR_URL%
curl -L -o resume-builder.exe %EXE_URL%

REM Check if files were downloaded
if not exist "resume-builder-1.0-SNAPSHOT.jar" (
    echo Failed to download resume-builder-1.0-SNAPSHOT.jar.
    exit /b 1
)
if not exist "resume-builder.exe" (
    echo Failed to download resume-builder.exe.
    exit /b 1
)

REM Run the EXE file
start resume-builder.exe

endlocal
