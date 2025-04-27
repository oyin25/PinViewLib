# PinVerificationView

A clean, customizable PIN entry view for Android apps with PIN validation, animations, and easy event handling.

This library helps you quickly integrate a beautiful 4-digit PIN screen with auto UI feedback and a shake animation for wrong attempts.

[![](https://jitpack.io/v/oyin25/PinVerificationLib.svg)](https://jitpack.io/#oyin25/PinVerificationLib)

---

## Features

- 4-digit PIN entry UI
- Auto-detect PIN completion
- Easy PIN validation with `setOnPinCompleteListener`
- Shake animation for wrong PIN
- Customizable layout and styles
- Lightweight and easy to integrate

---

## Installation

### Step 1: Add JitPack to your root `settings.gradle`

Groovy (settings.gradle):
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

Kotlin DSL (settings.gradle.kts):
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

---

### Step 2: Add the dependency in your `app/build.gradle`

```groovy
dependencies {
    implementation 'com.github.oyin25:PinVerificationLib:v1.0.0'
}
```

---

## Usage

### Step 1: Add the view to your XML layout

```xml
<com.HP.Verification.PinVerificationView
    android:id="@+id/pin_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

---

### Step 2: Access it in your Activity

```java
PinVerificationView pinView = findViewById(R.id.pin_view);

pinView.setOnPinCompleteListener(new PinVerificationView.OnPinCompleteListener() {
    @Override
    public void onPinComplete(String pin) {
        Toast.makeText(MainActivity.this, "Pin entered: " + pin, Toast.LENGTH_SHORT).show();

        // Example: Check if pin is correct
        if (pin.equals("1234")) {
            Toast.makeText(MainActivity.this, "Correct PIN!", Toast.LENGTH_SHORT).show();
        } else {
            pinView.shake(); // Shake animation on wrong PIN
        }
    }
});
```

---

## Important

- The library **auto detects** when 4 digits are entered.
- Call `shake()` manually if you want to show wrong PIN effect.
- You can customize the design by modifying the hosted_pin_ui.xml file.

---

## Screenshots

(Add your screenshots or GIF demos here if available)

---

## License

MIT License

```
MIT License

Copyright (c) 2025 oyin25

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions...
```

---

## Author

Made with passion by [@oyin25](https://github.com/oyin25)

