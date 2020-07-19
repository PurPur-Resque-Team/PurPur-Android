# 🌲 푸르푸르 구조대 - 환경을 위한 실천이 바로 보이는 환경 교육 어플리케이션 🌴

> ANGELHACK SEOUL 해커톤 참여
>
> 팀명 : 새싹비빔밥
> 
> 프로젝트 기간 2020.07.13 ~ 2020.07.19

<img width="1724" alt="푸르푸르로고" src="https://user-images.githubusercontent.com/45157374/87874254-459f4580-ca03-11ea-9032-f28557e7986b.png">

## 🔧 Tools

- Android Studio

- Zeplin

- Postman
  <br>
  
## 📌 Code Convention

- 변수명은 기본적으로 camelCase로 작성

- ID NAMING : 뷰이름_위젯줄인말_기능이름

- 커밋하기 전에 reformat code를 실행시켜서 코드를 정리해준다.
  <br>

## 🌞 Github Branching

- 개인 Branch를 이름으로 만든 뒤 개발한다.

- 개인 Branch에서 develop branch로 PR을 보낸다.

- 모든 기능이 완벽하면서, 모든 팀원이 동의할 때 Master 브랜치로 PR을 보낸다.
  <br>

## 🛠 Technology Stack

- Minimum SDK version 24

- Language : Kotlin

- Retrofit : REST API Library

- Gson : Json Data process Library

<br>

## 📝 Architecture Pattern

- MVVM 패턴

- Koin 라이브러리를 통한 DI(의존성 주입)


## 🔑 Dependency

```kotlin
//Retrofit 라이브러리 : https://github.com/square/retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.6.2'
    //Retrofit 라이브러리
    implementation 'com.squareup.retrofit2:retrofit-mock:2.6.2'
    // Retrofit2.
    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.3.0'

    //객체 시리얼라이즈를 위한 Gson 라이브러리 : https://github.com/google/gson
    implementation 'com.google.code.gson:gson:2.8.6'
    //Retrofit 에서 Gson 을 사용하기 위한 라이브러리
    implementation 'com.squareup.retrofit2:converter-gson:2.6.2'

    //okHttp
    implementation 'com.squareup.okhttp3:logging-interceptor:3.8.1'
    implementation 'com.squareup.okhttp3:okhttp:3.12.0'

    //리사이클러뷰 라이브러리
    implementation 'androidx.recyclerview:recyclerview:1.2.0-alpha04'

    //생명주기를 공유하기 위한 라이브러리
    implementation "androidx.appcompat:appcompat:1.1.0"
    //LiveData를 사용하기 위한 라이브러리
    implementation "androidx.lifecycle:lifecycle-viewmodel:2.2.0"

    //Lottie Library
    implementation 'com.airbnb.android:lottie:3.4.1'

    // Koin for Kotlin
    implementation "org.koin:koin-core:$koin_version"
    // Koin extended & experimental features
    implementation "org.koin:koin-core-ext:$koin_version"
    // Koin for Unit tests
    testImplementation "org.koin:koin-test:$koin_version"
    // Koin for Java developers
    implementation "org.koin:koin-java:$koin_version"

    // Koin for Android
    implementation "org.koin:koin-android:$koin_version"
    // Koin Android Scope features
    implementation "org.koin:koin-android-scope:$koin_version"
    // Koin Android ViewModel features
    implementation "org.koin:koin-android-viewmodel:$koin_version"
    // Koin Android Experimental features
    implementation "org.koin:koin-android-ext:$koin_version"

    // Koin AndroidX Scope features
    implementation "org.koin:koin-androidx-scope:$koin_version"
    // Koin AndroidX ViewModel features
    implementation "org.koin:koin-androidx-viewmodel:$koin_version"
    // Koin AndroidX Experimental features
    implementation "org.koin:koin-androidx-ext:$koin_version"


    //Material Components
    implementation 'com.google.android.material:material:1.3.0-alpha01'
```
