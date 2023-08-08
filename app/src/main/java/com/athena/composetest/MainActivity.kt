package com.athena.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.athena.composetest.ui.theme.ComposeTestTheme

//# 함수이름은 대문자로 시작한다. 왜냐하면 요소들과 구별하기 위해서!


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //setContent 블록은 구성 가능한 함수가 호출되는 활동의 레이아웃을 정의함.
            //'구성가능한 함수'는 다른 '구성가능한 함수'에서만 호출할 수 있다.
            MessageCard(Message("아테나", "컴포즈입니다. 바닐라라떼"))

        } //setContent
    }//onCreate
}//Component Activity

//Compose는 구성 가능한 함수를 중심으로 빌드 되어있음
//초기화, 상위요소에 연결에 초첨을 두지않고, 앱 모양을 설명하고 데이터 종속 항목을 제공하여
//좀 더 프로그래매틱 방식으로 UI를 정의한다.
//구성가능한 함수는 함수이름에 @Composable 주석을 추가하기만 하면 된다.
data class Message(val author: String, val body: String)

@Composable
// @Composable 주석은 Compose 라이브러리에서 UI 구성 요소를 선언하기 위해 사용되는 함수를 표시해준다.
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        //Row는 항목을 수평으로 배치한다.
        Image(
            painter = painterResource(id = R.drawable.ms17),
            contentDescription = "Contact profile picture",
            modifier = Modifier.size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {

            //Column은 요소를 수직으로 정렬할 수 있다.
            Text(text = msg.author)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
            //Text함수는 텍스트를 표시해준다.
        }
    }




}//MessageCard method

@Preview(showBackground = true)
//@Preview 주석은 Composable 함수를 미리보기로 표시하도록 지정하는 데 사용
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("---------------------", "========================")
    )
}//PreviewMessageCard method