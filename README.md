# 계산기 GUI 프로그램

이 프로젝트는 Java의 Swing 라이브러리를 사용하여 개발된 간단한 계산기 프로그램입니다. 이 프로그램은 더하기, 빼기, 곱하기, 나누기와 같은 기본적인 산술 연산을 위한 그래픽 사용자 인터페이스(GUI)를 제공합니다.

## 주요 기능

- 기본 산술 연산: 더하기, 빼기, 곱하기, 나누기.
- 숫자 및 연산 버튼이 배치된 그리드 레이아웃.
- 사용자가 입력한 값과 연산을 텍스트 필드에 표시.

## 필수 조건

- **Java JDK 8** 이상이 설치되어 있어야 합니다.
- Java IDE(예: IntelliJ IDEA, Eclipse) 또는 명령어를 통해 프로그램을 실행할 수 있어야 합니다.

## 설치 방법

1. 저장소를 클론합니다:
    ```bash
    git clone https://github.com/hsk0316/Java2_midterm_exam.git
    ```

2. 프로젝트 디렉토리로 이동합니다:
    ```bash
    cd Java2_midterm_exam
    ```

3. 선호하는 Java IDE(IntelliJ IDEA, Eclipse 등)에서 프로젝트를 열거나, 명령어를 사용하여 컴파일하고 실행합니다.

## 사용 방법

1. `Calculator` 클래스를 실행합니다. 그러면 계산기의 그래픽 사용자 인터페이스(GUI)가 표시됩니다.

2. 계산기는 다음과 같은 기능을 제공합니다:
   - 숫자 버튼(0-9)을 사용하여 숫자를 입력할 수 있습니다.
   - 연산자 버튼(÷, ×, −, +)을 클릭하여 산술 연산을 수행할 수 있습니다.
   - **C** 또는 **CE** 버튼을 사용하여 디스플레이를 지울 수 있습니다.

3. 연산 과정은 상단의 텍스트 필드에 표시됩니다.

## 코드 구조

- **Calculator.java**: 이 파일은 GUI를 생성하고 표시하는 메인 클래스입니다. 사용자 입력을 위한 디스플레이 필드와 숫자 및 연산 버튼이 포함되어 있습니다.

- 이 코드는 Java의 **Swing** 라이브러리를 사용하여 `JFrame`, `JPanel`, `JTextField`, `JButton`과 같은 GUI 컴포넌트를 생성합니다.

## 향후 개선 사항
 
- 실제 산술 연산을 처리하고 결과를 표시하는 기능을 구현할 예정입니다.
- 소수점 및 음수 처리를 위한 기능을 추가할 예정입니다.
- 잘못된 입력에 대한 오류 처리를 개선할 예정입니다.

## 작성자

- **한승규** - [hsk0316](https://github.com/hsk0316)
