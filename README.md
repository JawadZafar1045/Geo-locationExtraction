# Geo-locationExtraction
# 

Geo-locationExtraction is a lightweight utility class for Android apps that simplifies geolocation functionality. With LocationHelper, you can easily fetch the user's current location and retrieve the city name using reverse geocoding.

## Features

- Fetches the user's geographical coordinates (latitude and longitude) using the device's GPS.
- Performs reverse geocoding to obtain the city name corresponding to the user's location.
- Easy integration into Android applications with just a few lines of code.

## Getting Started

### Download LocationHelper

Clone or download the `LocationHelper.java` file from this repository.

### Add LocationHelper to Your Project

Copy the `LocationHelper.java` file into your Android project's source directory.

### Usage

In your activity or fragment, create an instance of `LocationHelper` passing the `Context` as a parameter. Then, call the `fetchLocation()` method to initiate location updates.

```java
LocationHelper locationHelper = new LocationHelper(this);
locationHelper.fetchLocation();
