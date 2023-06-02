# HTTP/3 Test App

This Android app is designed to test and demonstrate the implementation of HTTP/3 in an Android environment. It utilizes the Cronet library with HTTP/3 support to make requests and receive responses over the HTTP/3 protocol.

## Features

- Establishes connections using the HTTP/3 protocol.
- Sends HTTP requests using HTTP/3.
- Receives HTTP responses over the HTTP/3 protocol.
- Displays response data on the UI.

## Requirements

- Android device running Android API level 24 or higher.
- Internet connectivity.

## Installation

1. Clone the repository to your local machine.

2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator.

## Dependencies

This app relies on the following libraries and dependencies:

- Cronet: A networking library developed by Google that provides support for making requests over HTTP/3.
- OkHttp: An HTTP client library that works seamlessly with Cronet and provides additional features and utilities.
- OkHttp Logging Interceptor: An OkHttp interceptor for logging HTTP request and response information.

## Usage

1. Launch the app on your Android device.
2. Tap the "Refresh" button a few times (first and second request usually done in HTTP/2).
3. The app will make an HTTP request using the HTTP/3 protocol to https://quic.tech:8443/.
4. The response data will be displayed on the screen, including the response headers and body.

## Contributing

Contributions are welcome! If you encounter any issues or have suggestions for improvements, please submit a pull request or open an issue on the GitHub repository.

## License

This project is licensed under the [MIT License](LICENSE).
