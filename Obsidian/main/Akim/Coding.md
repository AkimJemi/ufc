##### 오픈소스는 이렇게 뜯어보고 참여하면 됩니다(리액트 소스코드 뜯어보기)

command
package.json
　bulid

component
flat
논리 구조

README.md
 package.json
 entry command -> build
 file access
 import 영역 확인
 핵심 "로직영역"
 선언된 함수 영역
 MDN
##### ｇｇｇ
[0:58](https://www.youtube.com/watch?v=qaMBfLjCg_c&t=58s) 리드미 파일을 천천히 읽는다. 
-> 설마 이걸 안 읽겠어? 싶지만 안 읽는 사람이 많고, 안 읽고 진행하다가 오류 해결하며 시간 블랙홀에 한번 빠져봐야 정신차린다. 
[3:55](https://www.youtube.com/watch?v=qaMBfLjCg_c&t=235s) package.json 파일 부터 확인한다. 
-> 이 안에 소스코드를 가동시키는 커맨드, 즉 엔트리 코드가 작성되어 있다. 
[9:00](https://www.youtube.com/watch?v=qaMBfLjCg_c&t=540s) 모든 js 코드들을 리액트 컴포넌트처럼 모듈화 해야한다는 고정관념을 버리자 
-> 바닐라 js 기본기가 있어야 한다. 
[11:00](https://www.youtube.com/watch?v=qaMBfLjCg_c&t=660s) 전체 프로그램이 작성된 논리 구조를 생각해보자. import 부분 | 함수를 호출하는 로직 부분 | 특정 로직의 구현을 담당하는 함수 부분 이렇게 생각하자. 
-> 아래서 부터 올라가지 말고, 위에서 부터 한줄 한줄 보라. 
-> 함수들을 호출해서 로직을 담당하는 부분이 핵심이다. 
[11:42](https://www.youtube.com/watch?v=qaMBfLjCg_c&t=702s) 구조 잡기 상세 설명 
[17:20](https://www.youtube.com/watch?v=qaMBfLjCg_c&t=1040s) 정체 불명의 변수를 만나면 당황하지 말고 주석을 읽자. 
[17:50](https://www.youtube.com/watch?v=qaMBfLjCg_c&t=1070s) 오픈소스 분석하다 보면 실력이 늘 수 밖에 없는 이유 
-> 기본기가 탄탄한 개발자가 정성스럽게 주석까지 달아서 작성한 코드 보다보면 자연스럽게 자주 사용되는 기본기부터 시작해서, 좋은 코드 냄새를 맡는 안목이 길러질 수 밖에 없다. 
-> 백기선님 클린 코드 강의 강추, 책은 비추 좋은 코드를 잘 맡는 사냥개로 변신 
[18:25](https://www.youtube.com/watch?v=qaMBfLjCg_c&t=1105s) 좋은 주석의 표본을 볼 수 있다. 
-> 그럼 내가 프로그래밍 할 때 주석을 어떻게 달면 남들이 읽기 편할까? 를 고민하게 된다. 
[19:14](https://www.youtube.com/watch?v=qaMBfLjCg_c&t=1154s) 한줄 한줄 해석하는 훈련을 해야 하는 이유: 코드를 이해하고, 리뷰하는 속도가 빨라진다. 
-> 너무 당연한 말 같지만, 살면서 코드 수만, 수십만줄 보고 살아야 하는데 정말 중요하다고 생각한다. 
-> 리액트에서 정말 중요한 부분인 만큼, 구조화가 정말 잘 되어 있다. 
-> 각 함수로 전달되는 인수들이 많지 않다 (1~3개) 
-> 나 같은 초보자가 흔히 하는 무친 스파게티 풀파워 네스팅 없이 어떻게 코드 짜야할 지 영감을 얻을 수 있음 
[20:30](https://www.youtube.com/watch?v=qaMBfLjCg_c&t=1230s) 최근 JS 는 절차 지향형, 함수형 프로그래밍을 지향한다. 
-> 중복 코드 없애기, 모듈 간 의존도 낮추기 (디커플링) 
-> 백엔드 개발자라면 김영한님 강의 초강추 
-> 연극에서 줄리엣을 캐스팅하는 사람과 배우인 줄리엣은 같은 사람이면 안됨 
-> 설정하는 놈, 실제로 쓰는 놈 분리하는 것 부터가 SOLID 시작임 
[23:00](https://www.youtube.com/watch?v=qaMBfLjCg_c&t=1380s) useState 가 궁금한데, useState 만 대충 훑어보면 되는거 아닌가요? 
-> 눈 가린채로 코끼리 귀 만져보고 고양이 귀라고 하는 격 
-> 폭포의 상류가 아니라 하류만 보면 수원지에서 벌어지는 일을 알 수가 없다. 
[23:30](https://www.youtube.com/watch?v=qaMBfLjCg_c&t=1410s) 이왕 라이브러리를 분석할 거면 시작점 부터 꼼꼼하게 봐야한다. 
-> 모듈화 시키는게 기본인데, 상위 모듈 하나도 모른채로 하위 모듈만 보는것이 과연 분석의 의미가 있을까? 고민해보자

##### 오픈소스 코드 분석하는 방법(존 슐린커트 형님의 is-number)
[0:00](https://www.youtube.com/watch?v=3gXGMvRko5E&t=0s) 인트로 
[0:30](https://www.youtube.com/watch?v=3gXGMvRko5E&t=30s) is-number 설명 시작 
[2:56](https://www.youtube.com/watch?v=3gXGMvRko5E&t=176s) 충격과 공포의 자바스크립트 숫자 처리 현실 
[4:25](https://www.youtube.com/watch?v=3gXGMvRko5E&t=265s) 벤치마크 
[5:10](https://www.youtube.com/watch?v=3gXGMvRko5E&t=310s) 깃허브 탐방 시작 
[7:00](https://www.youtube.com/watch?v=3gXGMvRko5E&t=420s) 좋은 라이브러리 특 
[7:30](https://www.youtube.com/watch?v=3gXGMvRko5E&t=450s) "이게 코드다" 
[10:10](https://www.youtube.com/watch?v=3gXGMvRko5E&t=610s) 초보자 특: 그냥 typeof씀 
[10:55](https://www.youtube.com/watch?v=3gXGMvRko5E&t=655s) 테스트 코드 
[13:20](https://www.youtube.com/watch?v=3gXGMvRko5E&t=800s) 성능 체크 코드 
[14:50](https://www.youtube.com/watch?v=3gXGMvRko5E&t=890s) 바로 Pull Request 갈기기 
[15:10](https://www.youtube.com/watch?v=3gXGMvRko5E&t=910s) "더 최적화하겠다" 
[18:11](https://www.youtube.com/watch?v=3gXGMvRko5E&t=1091s) 수년째 무플 ㅠㅠ 
[19:00](https://www.youtube.com/watch?v=3gXGMvRko5E&t=1140s) 마무리 멘트 
[19:55](https://www.youtube.com/watch?v=3gXGMvRko5E&t=1195s) 쉬운 라이브러리 찾기 
[21:50](https://www.youtube.com/watch?v=3gXGMvRko5E&t=1310s) 오픈소스의 위대함 설파 
[22:30](https://www.youtube.com/watch?v=3gXGMvRko5E&t=1350s) 리액트 작성자 보기fiekdiw ]
