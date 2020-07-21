# 🌲 푸르푸르 구조대 - 환경을 위한 실천이 바로 보이는 환경 교육 어플리케이션 🌴

> ANGELHACK SEOUL 해커톤 참여
>
> 팀명 : 새싹비빔밥
> 
> 프로젝트 기간 2020.07.13 ~ 2020.07.19

<img width="1724" alt="푸르푸르로고" src="https://user-images.githubusercontent.com/45157374/87874254-459f4580-ca03-11ea-9032-f28557e7986b.png">

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

## 주요기능 

### 0. 닉네임 설정

<img width="638" alt="스크린샷 2020-07-19 오후 11 04 44" src="https://user-images.githubusercontent.com/37479631/87876620-4096c200-ca14-11ea-8a5a-5a03395d9f89.png">

#### 시연 영상

![ezgif com-video-to-gif (1)](https://user-images.githubusercontent.com/45157374/87998440-e5a7bc80-cb32-11ea-8d9e-f5c1d9c5f8be.gif)


- 초기 사용 시 회원의 닉네임을 정할 수 있다.

### 1. 미션 진행에 따라 달라지는 홈 화면

<img width="638" alt="스크린샷 2020-07-19 오후 11 10 20" src="https://user-images.githubusercontent.com/37479631/87876728-1abded00-ca15-11ea-8c82-e6dcf5faa277.png">
<img width="638" alt="스크린샷 2020-07-19 오후 11 10 30" src="https://user-images.githubusercontent.com/37479631/87876731-1eea0a80-ca15-11ea-89aa-0f297236d4c2.png">
<img width="638" alt="스크린샷 2020-07-19 오후 11 10 37" src="https://user-images.githubusercontent.com/37479631/87876734-1f82a100-ca15-11ea-8011-34bc5fd973bb.png">
<img width="638" alt="스크린샷 2020-07-19 오후 11 10 42" src="https://user-images.githubusercontent.com/37479631/87876737-214c6480-ca15-11ea-8a55-8e71a2fdf043.png">

- 미션 진행 상황에 따라 동물, 섬, 배경이 달라진다.
- BindingAdapter에 확장함수를 구현하여 서버에서 받은 상태에 따라 이미지를 교체한다.

BindingAdapter.kt

```Kotlin
@BindingAdapter("setIslandBg")
fun ImageView.setIslandBg(status : Int) {
    if(status==0||status==1) setBackgroundResource(IslandBg_STATE_LIST[status])
    else setBackgroundResource(IslandBg_STATE_LIST[status])
}

@BindingAdapter("setIsland")
fun ImageView.setIsland(status : Int) {
    if(status==0||status==1) setImageResource(Island_STATE_LIST[status])
    else setImageResource(Island_STATE_LIST[2])
}

@BindingAdapter("idx", "status")
fun ImageView.setAnimal(idx: Int, status : Int) {
    visibility = VISIBLE
    setImageResource(ANIMAL_STATE_LIST[idx][status])
}
```

### 2. 동물별 미션 진행

<img width="640" alt="스크린샷 2020-07-19 오후 11 14 37" src="https://user-images.githubusercontent.com/37479631/87876868-d0893b80-ca15-11ea-8a23-6aaaf2a93b52.png">
<img width="640" alt="스크린샷 2020-07-19 오후 11 15 11" src="https://user-images.githubusercontent.com/37479631/87876870-d1ba6880-ca15-11ea-9270-a583c2c85a4d.png">

- 원하는 동물을 선택해 5개의 카드 중 하나를 선택하여 미션을 수행할 수 있다.
- 미션카드는 RecyclerView를 사용해 구현했다.
- RecyclerView item에 clickListener 인터페이스를 구현하고 override하여 이미 클리어한 미션은 다시 선택하지 못하도록 하였다.

```kotlin
adapter = CardAdapter(object :
            CardViewHolder.MissionItemClickListener {
            override fun missionItemClick(position: Int, missions: ArrayList<Mission>) {
                Log.e("iscleared ", missions[position].isCleared.toString())
                selectedCardIdx = missions[position].missionIdx
                when (missions[position].isCleared) {
                    0 -> {
                      viewDataBinding.actDetailIvMissionBtn
                      .setImageResource(R.drawable.btn_done)
                        viewDataBinding.actDetailIvMissionBtn.isClickable = true
                    }
                    1 -> {
                        viewDataBinding.actDetailIvMissionBtn
                      .setImageResource(R.drawable.btn_done_act)
                        viewDataBinding.actDetailIvMissionBtn.isClickable = false
                    }
                }
                viewDataBinding.actDetailIvMissionBtn.visibility = View.VISIBLE
                viewDataBinding.actDetailIvMissionImg.visibility = View.VISIBLE
                viewDataBinding.actDetailTvMissionText.visibility = View.VISIBLE
                viewDataBinding.actDetailTvMission.visibility = View.GONE
                viewDataBinding.actDetailIvMissionImg
              .setImageResource(PURPUR.MISSION_SELECT_LIST[position].image)
                viewDataBinding.actDetailTvMissionText.text =
                    PURPUR.MISSION_SELECT_LIST[position].text
                viewDataBinding.actDetailIvMissionBack
              .setBackgroundResource(PURPUR.MISSION_SELECT_LIST[position].backGround)
            }
        })
```

### 3. 미션 수행 인증 진행

<img width="638" alt="스크린샷 2020-07-19 오후 11 25 26" src="https://user-images.githubusercontent.com/37479631/87877064-23172780-ca17-11ea-8ea1-de986ef200f3.png">



- 마구잡이로 미션 수행을 누르는 것을 방지하기 위해 랜덤 숫자를 띄워 인증을 진행한다.
- java의 Random 클래스를 이용해 0-9 사이의 랜덤 숫자 4개를 만들어 한글로 바꿔 띄워준다.

QuizDialogViewModel.kt

```kotlin
fun getRandomNumbers() {
        val numbers = Array(4) { -1 }

        val random = Random()
        var i = 0
        while (i < 4) {
            numbers[i] = random.nextInt(10)
            var j = 0
            while (j < i) {
                if (numbers[i] == numbers[j]) {
                    i -= 1
                }
                j++
            }
            i++
        }
        _randomNumList.value = numbers
    }
```

QuizDialogFragment.kt

```kotlin
private fun observeData() {
        quizDialogViewModel.randomNumList.observe(this, androidx.lifecycle.Observer {
            binding.dialogQuizTvFirst.text = PURPUR.MISSION_CLEAR_QUIZ_NUMBER[it[0]]
            binding.dialogQuizTvSecond.text = PURPUR.MISSION_CLEAR_QUIZ_NUMBER[it[1]]
            binding.dialogQuizTvThird.text = PURPUR.MISSION_CLEAR_QUIZ_NUMBER[it[2]]
            binding.dialogQuizTvFourth.text = PURPUR.MISSION_CLEAR_QUIZ_NUMBER[it[3]]

            QUIZ_ANSWER.addAll(it)
        })

    }
```

### 4. 미션 진행 상태에 따라 상황을 progress bar로 표현

<img width="638" alt="스크린샷 2020-07-19 오후 11 39 49" src="https://user-images.githubusercontent.com/37479631/87877415-257a8100-ca19-11ea-8beb-f10bddc5e148.png">

<img width="639" alt="스크린샷 2020-07-19 오후 11 48 16" src="https://user-images.githubusercontent.com/37479631/87877631-53ac9080-ca1a-11ea-867b-e0900cb2166e.png">



- 섬과 동물별 미션 진행 상태를 직관적으로 확인 가능하도록 progress bar로 표시한다.
- 커스텀 프로그레스바를 이용해 stroke가 있고 색이 다르게 차오르도록 구현했다.

Progress_vertical.xml

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<layer-list
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_height="wrap_content"
    android:layout_width="wrap_content">
    <item android:id="@android:id/background">
        <shape>
            <stroke android:color="#ffffff"
                android:width="3dp" />
            <corners android:radius="12dp" />
            <solid android:color="#dbe0e9"/>

        </shape>
    </item>
    <item android:id="@android:id/progress"
        android:top="3dp"
        android:bottom="3dp"
        android:left="3dp"
        android:right="3dp">
        <clip
            android:clipOrientation="vertical"
            android:gravity="bottom">
            <shape>
                <corners android:bottomLeftRadius="12dp"
                    android:bottomRightRadius="12dp"/>
                <solid android:color="#fed039" />
            </shape>
        </clip>
    </item>
</layer-list>
```

IslandActivity.kt

```kotlin
val progressAnimator =
                ObjectAnimator.ofInt(act_main_pb, "progress", 0, it.islandProgress)
            progressAnimator.duration = 1000
            val ll = LinearInterpolator()
            progressAnimator.interpolator = ll
            progressAnimator.start()
```

### 5. 앱에서 BackgroundMusic 재생

- 아이들이 흥미를 느낄 수 있도록 BGM이 재생되도록 구현했다.
- MediaPlayer를 사용해 음악을 무한루프로 재생하고 AudioManager를 사용해 음악이 재생중이면 반복재생되지 않도록 한다.

IslandActivity.kt

```kotlin
private fun setMusic(){
        val mediaPlayer = MediaPlayer.create(this, R.raw.purpur_bgm)
        mediaPlayer.isLooping = true
        val manager = this.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        if (!manager.isMusicActive) {
            mediaPlayer.start()
        }
    }
```

### 시연 영상(1,2,3,4,5 기능)

![ezgif com-video-to-gif (2)](https://user-images.githubusercontent.com/45157374/87998687-96ae5700-cb33-11ea-85d4-0315cefc4427.gif)

