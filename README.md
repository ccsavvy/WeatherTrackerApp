# Weather Tracker

## Overview
The **Weather Tracker** app is a Kotlin-based application designed to showcase real-time weather updates for a user-selected city. 
It leverages **Jetpack Compose**, **MVVM + clean architecture**, **Modularisation** and **WeatherAPI.com** for seamless functionality and clean code.

---

## Features

### Home Screen
- Displays weather information for the selected city:
  - **City Name**
  - **Temperature**
  - **Weather Condition** (with API-sourced icon)
  - **Humidity** (%)
  - **UV Index**
  - **Feels Like Temperature**
- Prompts the user to search if no city is saved.
- Includes a search bar for city queries.

### Search Functionality
- Displays a card with search result.
- Updates the Home Screen upon selection and persists the city and with its weather data.

### Local Storage
- Saves the selected city using **DataStore**.
- Automatically reloads the saved city and its weather details on app launch.

---

## Additional Functionalities

- **ProgressBar for Loading State**: 
  - A **ProgressBar** is displayed when fetching weather data from the API, providing users with feedback during data retrieval. This enhances the user experience by making the app feel more responsive and visually informative.
  
- **Error Handling**:
  - Graceful error handling is implemented to display user-friendly messages in case of network failures, invalid city input, or API issues.
 
---

## Tech Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM
- **Dependency Injection**: Hilt
- **Networking**: Retrofit with Gson
- **Storage**: DataStore

---

## Setup Instructions

1. **Clone the Repository**
   - Run the following command to clone the repository:
     ```bash
     git clone <repository-url>
     cd weather-tracker
     ```

2. **Set Up API Key**
   - To fetch weather data, you need to configure an API key:
     1. Obtain an API key from [WeatherAPI.com](https://www.weatherapi.com/).
     2. Open the project directory.
     3. Locate or create a file named `build.gradle.kts` in the app direcotry `:app:data` module.
     4. Add the following entry to `build.gradle.kts(:app:data)`:
        ```properties
        buildConfigField("String", "WEATHER_API_KEY", "\"your_api_key_here\"")
        ```

3. **Build and Run**
   - Open the project in **Android Studio Android Studio Ladybug | 2024.2.1 Patch 3
Build #AI-242.23339.11.2421.12700392, built on November 22, 2024
Runtime version: 21.0.3+-79915917-b509.11 aarch64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
Toolkit: sun.lwawt.macosx.LWCToolkit
macOS 15.2
GC: G1 Young Generation, G1 Concurrent GC, G1 Old Generation
Memory: 2048M
Cores: 10
Metal Rendering is ON
Registry:
  debugger.new.tool.window.layout=true
  ide.experimental.ui=true
  i18n.locale=
Non-Bundled Plugins:
  wu.seal.tool.jsontokotlin (3.7.6)
**.
   - Sync Gradle files.
   - Run the app on an emulator or physical device.

---

## Notes
1. The app fetches real-time weather data based on the selected city and handles API errors gracefully.
2. The Figma design was closely followed for visual consistency except (search bar).
3. Data persistence ensures a smooth user experience across app launches.

---

## Screenshots
![Screenshot_20241217_190440](https://github.com/user-attachments/assets/e3955ba8-d4e7-407a-a985-0c9833f7a09e)
![Screenshot_20241217_190854](https://github.com/user-attachments/assets/9b456556-6cfd-49ea-aa64-1e6b9f6a5e0d)
![Screenshot_20241217_190934](https://github.com/user-attachments/assets/f86ecf2a-3f97-4846-9050-9af15325dd86)
![Screenshot_20241217_190534](https://github.com/user-attachments/assets/412f8fd3-c9b1-4f32-ab95-c0ef1505d38e)
![Screenshot_20241217_191121](https://github.com/user-attachments/assets/802c39d9-014a-4b52-a5c2-08b3fa261bb3)


