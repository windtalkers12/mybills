프로젝트명:  간편장부

1. 프로젝트 구성
- 본 프로젝트는 Android Studio 기반으로 개발된 가계부 애플리케이션입니다.
- 제출한 압축파일(.zip)에는 전체 프로젝트 파일이 포함되어 있습니다.

2. 실행 환경
- Android Studio 버전: Chipmunk 이상 권장 (Arctic Fox 또는 최신 버전도 가능)
- JDK: 1.8 이상
- Gradle: Android Studio에서 자동 다운로드됨

3. 실행 절차
① Android Studio 실행
② File > Open 클릭
③ 제출한 압축을 해제한 프로젝트 폴더를 선택하여 열기
④ Gradle Sync가 자동으로 시작되며, 오류 없이 완료될 때까지 기다리기
⑤ 왼쪽에서 app 모듈의 java > [your.package.name] > MainActivity.java를 열기
⑥ 상단의 실행버튼 run -> Run app 클릭
⑦ 에뮬레이터 또는 연결된 실제 Android 폰에서 앱이 실행됨

4. 주요 기능 소개
- 수입/지출 항목 추가 및 삭제
- 하루 단위 금액 조회 및 그래프 표시 (MPAndroidChart 사용)
- 월별 예산 설정 및 잔액 계산
- 날짜 선택을 통한 과거 내역 입력 가능
- 바 차트는 1일, 15일, 말일에만 축 라벨 표시

6. 테스트 확인용
- 기본적인 수입/지출 데이터를 입력하면 메인화면 및 통계 탭에서 바로 확인 가능합니다.

감사합니다.
