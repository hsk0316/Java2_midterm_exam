package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 계산기 GUI 프로그램.
 * 이 클래스는 JFrame을 확장하여 계산기의 기본 UI를 구성합니다.
 * 더하기, 빼기, 곱하기, 나누기 등의 연산 버튼을 포함하며, 소수점 및 +/- 연산, C 등의 기능을 제공합니다.
 * <p>추가적으로, 콤보박스를 통해 1/x, 제곱, 제곱근 등의 함수 연산을 수행할 수 있도록 지원합니다.</p>
 *
 * <p>오류 메시지가 표시된 후 오류 상태를 초기화하고, 오류 메시지 표시 시 숫자 입력이 정상적으로 되돌아가도록 개선되었습니다.</p>
 *
 * @version 5.0.0
 * @since 2024-10-17
 *
 * @created 2024-10-17
 * @lastModified 2024-11-01
 *
 * @changelog
 * <ul>
 *   <li>2024-10-17: 최초 생성 UI 디자인, 버튼 배치 (한승규)</li>
 *   <li>2024-10-19: 숫자 버튼 클릭 시 디스플레이에 숫자가 나타나도록 기능 추가 (한승규)</li>
 *   <li>2024-10-20: 연산자 버튼 클릭 시 디스플레이에 연산자가 나타나도록 기능 추가 (한승규)</li>
 *   <li>2024-10-27: 기본적인 사칙연산 기능 추가 (한승규)</li>
 *   <li>2024-10-28: 소수점 및 +/- 기능 추가 (한승규)</li>
 *   <li>2024-10-29: CE, C, ← 버튼 기능 추가 (한승규)</li>
 *   <li>2024-10-30: +/- 기능 수정 및 소수점 상태 초기화 기능 추가 (한승규)</li>
 *   <li>2024-10-31: 오류 메시지 표시 후 입력 초기화 추가 (한승규)</li>
 *   <li>2024-10-31: 0으로 나누기 시 오류 메시지 추가 (한승규)</li>
 *   <li>2024-10-31: 부동 소수점 오류 처리 기능 추가 (한승규)</li>
 *   <li>2024-11-01: 콤보박스 기능 추가로 1/x, 제곱, 제곱근 연산 추가(GUI 만), CE 버튼 및 기능 삭제 (한승규)</li>
 * </ul>
 */
public class Calculator extends JFrame {

    /**
     * 사용자가 입력한 숫자 및 연산자를 표시하는 JTextField 컴포넌트입니다.
     * 숫자와 연산자 버튼을 클릭할 때마다 해당 값이 이 필드에 표시됩니다.
     */
    private JTextField display;
    private double num1 = 0;        // 첫 번째 숫자
    private double num2 = 0;        // 두 번째 숫자
    private String operator = "";   // 연산자
    private boolean decimalUsed = false;  // 소수점 사용 여부
    private boolean errorShown = false;   // 오류 메시지가 표시되었는지 여부

    /**
     * 계산기 GUI를 초기화하는 생성자입니다.
     * 프레임, 디스플레이, 콤보박스 및 버튼들을 설정하고 레이아웃에 배치합니다.
     * 이 생성자는 계산기의 GUI 요소들을 구성하는 역할을 합니다.
     * <p>콤보박스를 통해 1/x, 제곱, 제곱근 연산을 수행할 수 있습니다.</p>
     *
     * @created 2024-10-17
     * @lastModified 2024-11-01
     * @changelog
     * <ul>
     *   <li>2024-10-17: 최초 생성 UI 디자인, 버튼 배치 (한승규)</li>
     *   <li>2024-10-19: 숫자 버튼 클릭 시 디스플레이에 숫자가 나타나도록 기능 추가 (한승규)</li>
     *   <li>2024-10-20: 연산자 버튼 클릭 시 디스플레이에 연산자가 나타나도록 기능 추가 (한승규)</li>
     *   <li>2024-10-27: 기본적인 사칙연산 기능 추가 (한승규)</li>
     *   <li>2024-10-28: 소수점 및 +/- 기능 추가 (한승규)</li>
     *   <li>2024-10-29: CE, C, ← 버튼 기능 추가 (한승규)</li>
     *   <li>2024-10-30: +/- 기능 수정 및 소수점 상태 초기화 기능 추가 (한승규)</li>
     *   <li>2024-10-31: 오류 메시지 표시 후 입력 초기화 추가 (한승규)</li>
     *   <li>2024-10-31: 0으로 나누기 시 오류 메시지 추가 (한승규)</li>
     *   <li>2024-10-31: 부동 소수점 오류 처리 기능 추가 (한승규)</li>
     *   <li>2024-11-01: 콤보박스 기능 추가로 1/x, 제곱, 제곱근 연산 추가(GUI 만), CE 버튼 및 기능 삭제 (한승규)</li>
     * </ul>
     */
    public Calculator() {
        // 프레임 설정
        setTitle("계산기");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 레이아웃 설정
        setLayout(new BorderLayout());

        // 디스플레이 설정
        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setBackground(Color.WHITE);
        display.setPreferredSize(new Dimension(300, 60));
        add(display, BorderLayout.NORTH);

        // 콤보박스 설정
        String[] comboOptions = {"1/x", "x^2", "√x"};
        JComboBox<String> functionComboBox = new JComboBox<>(comboOptions);
        functionComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        functionComboBox.setPreferredSize(new Dimension(80, 30));

        // 콤보박스에 액션 리스너 추가
        functionComboBox.addActionListener(e -> applyFunction((String) functionComboBox.getSelectedItem()));

        // 버튼 패널 설정
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBackground(Color.YELLOW);

        // 버튼 배열
        String[] buttons = {
                "", "←", "C", "÷",
                "7", "8", "9", "×",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", "+/-", ".", "="
        };

        // 버튼 추가 및 이벤트 리스너 설정
        for (String text : buttons) {
            if (text.equals("")) {
                buttonPanel.add(functionComboBox);  // 콤보박스를 첫 번째 위치에 추가
                continue;
            }

            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));

            // 숫자 버튼 처리
            if ("0123456789".contains(text)) {
                button.addActionListener(e -> {
                    if (errorShown) {  // 오류 메시지 후 초기화
                        display.setText("0");
                        errorShown = false;
                    }
                    if (display.getText().equals("0")) {
                        display.setText(text);
                    } else {
                        display.setText(display.getText() + text);
                    }
                });
            }
            // 연산자 버튼 처리
            else if ("÷×-+".contains(text)) {
                button.addActionListener(e -> {
                    try {
                        num1 = Double.parseDouble(display.getText());  // 첫 번째 숫자 저장
                        operator = text;  // 연산자 저장
                        display.setText(display.getText() + " " + operator + " ");
                        decimalUsed = false;  // 연산 후 소수점 사용 초기화
                    } catch (NumberFormatException ex) {
                        display.setText("ERROR");  // 형식 오류 처리
                        errorShown = true;
                    }
                });
            }
            // '=' 버튼 처리
            else if (text.equals("=")) {
                button.addActionListener(e -> {
                    try {
                        String[] parts = display.getText().split(" ");
                        if (parts.length == 3) {
                            num1 = Double.parseDouble(parts[0]);
                            operator = parts[1];
                            num2 = Double.parseDouble(parts[2]);

                            double result = 0;
                            switch (operator) {
                                case "+" -> result = num1 + num2;
                                case "-" -> result = num1 - num2;
                                case "×" -> result = num1 * num2;
                                case "÷" -> {
                                    if (num2 == 0) {
                                        display.setText("ERROR");  // 0으로 나누기 시 오류 표시
                                        errorShown = true;
                                        return;
                                    } else {
                                        result = num1 / num2;
                                    }
                                }
                            }
                            // 부동 소수점 오류 확인
                            if (Double.isNaN(result) || Double.isInfinite(result)) {
                                display.setText("ERROR");
                                errorShown = true;
                            } else {
                                display.setText(String.valueOf(result));
                                num1 = result;
                                decimalUsed = false;
                            }
                        }
                    } catch (NumberFormatException ex) {
                        display.setText("ERROR");  // 형식 오류 처리
                        errorShown = true;
                    }
                });
            }
            // +/- 버튼 처리 수정
            else if (text.equals("+/-")) {
                button.addActionListener(e -> {
                    try {
                        String currentText = display.getText();
                        String[] parts = currentText.split(" ");

                        if (parts.length > 0) {
                            String lastNumber = parts[parts.length - 1];
                            double value = Double.parseDouble(lastNumber) * -1;  // 부호 반전
                            parts[parts.length - 1] = String.valueOf(value);

                            display.setText(String.join(" ", parts));  // 부호 변경된 숫자 업데이트
                        }
                    } catch (NumberFormatException ex) {
                        display.setText("ERROR");  // 부호 반전 중 오류 처리
                        errorShown = true;
                    }
                });
            }
            // 소수점 버튼 처리
            else if (text.equals(".")) {
                button.addActionListener(e -> {
                    if (!decimalUsed) {
                        if (errorShown) {  // 오류 메시지 후 초기화
                            display.setText("0");
                            errorShown = false;
                        }
                        display.setText(display.getText() + ".");
                        decimalUsed = true;
                    }
                });
            }
            // ← 버튼 처리: 마지막 문자 삭제 및 소수점 초기화
            else if (text.equals("←")) {
                button.addActionListener(e -> {
                    if (errorShown) {  // 오류 메시지 후 초기화
                        display.setText("0");
                        errorShown = false;
                    } else {
                        String currentText = display.getText();
                        if (currentText.length() > 1) {
                            if (currentText.endsWith(".")) {
                                decimalUsed = false;
                            }
                            display.setText(currentText.substring(0, currentText.length() - 1));
                        } else {
                            display.setText("0");
                            decimalUsed = false;
                        }
                    }
                });
            }
            // C 버튼 처리: 모든 초기화
            else if (text.equals("C")) {
                button.addActionListener(e -> {
                    display.setText("0");
                    num1 = 0;
                    num2 = 0;
                    operator = "";
                    decimalUsed = false;
                    errorShown = false;  // 오류 상태 초기화
                });
            }
            buttonPanel.add(button);
        }

        // 버튼 패널을 중앙에 추가
        add(buttonPanel, BorderLayout.CENTER);
    }

    /**
     * 선택한 콤보박스 기능을 적용하는 메서드입니다.
     * @param function 선택된 함수 연산 ("1/x", "x^2", "√x")
     */
    private void applyFunction(String function) {
        try {
            double value = Double.parseDouble(display.getText());
            double result = switch (function) {
                case "1/x" -> 1 / value;
                case "x^2" -> Math.pow(value, 2);
                case "√x" -> Math.sqrt(value);
                default -> value;
            };
            display.setText(String.valueOf(result));
        } catch (NumberFormatException | ArithmeticException ex) {
            display.setText("ERROR");
            errorShown = true;
        }
    }

    /**
     * 계산기 GUI를 실행하는 메인 메서드입니다.
     * 이 메서드는 GUI를 시작하고 화면에 표시합니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}