package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 계산기 GUI 프로그램.
 * 이 클래스는 JFrame을 확장하여 계산기의 기본 UI를 구성합니다.
 * 더하기, 빼기, 곱하기, 나누기 등의 연산 버튼을 포함한 계산기의 GUI를 구현합니다.
 *
 * @author 한승규
 * @version 2.0.0
 * @since 2024-10-27
 *
 * @created 2024-10-17
 * @lastModified 2024-10-27
 *
 * @changelog
 * <ul>
 *   <li>2024-10-17: 최초 생성 (한승규)</li>
 *   <li>2024-10-20: 연산자 버튼 클릭 시 디스플레이에 연산자가 나타나도록 기능 추가 (한승규)</li>
 *   <li>2024-10-27: 기본적인 사칙연산 기능 추가 (한승규)</li>
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

    /**
     * 계산기 GUI를 초기화하는 생성자입니다.
     * 프레임, 디스플레이 및 버튼들을 설정하고 레이아웃에 배치합니다.
     * 이 생성자는 계산기의 GUI 요소들을 구성하는 역할을 합니다.
     *
     * @created 2024-10-17
     * @lastModified 2024-10-27
     *
     * @changelog
     * <ul>
     *   <li>2024-10-17: 최초 생성 (한승규)</li>
     *   <li>2024-10-20: 연산자 버튼 클릭 시 디스플레이에 연산자가 나타나도록 기능 추가 (한승규)</li>
     *   <li>2024-10-27: 기본적인 사칙연산 기능 추가 (한승규)</li>
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

        // 버튼 패널 설정
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBackground(Color.YELLOW);

        // 버튼 배열
        String[] buttons = {
                "←", "CE", "C", "÷",
                "7", "8", "9", "×",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", "+/-", ".", "="
        };

        // 버튼 추가
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));

            // 숫자 버튼 처리 (0~9)
            if ("0123456789".contains(text)) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (display.getText().equals("0")) {
                            display.setText(text);
                        } else {
                            display.setText(display.getText() + text);
                        }
                    }
                });
            }

            // 연산자 버튼 처리 (÷, ×, -, +)
            else if ("÷×-+".contains(text)) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        num1 = Double.parseDouble(display.getText());  // 첫 번째 숫자 저장
                        operator = text;  // 연산자 저장
                        display.setText(display.getText() + " " + operator + " ");  // 숫자 뒤에 연산자를 표시
                    }
                });
            }

            // '=' 버튼 처리: 계산 수행
            else if (text.equals("=")) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String[] parts = display.getText().split(" ");  // 공백으로 숫자와 연산자 분리
                        if (parts.length == 3) {
                            num1 = Double.parseDouble(parts[0]);
                            operator = parts[1];
                            num2 = Double.parseDouble(parts[2]);

                            double result = 0;

                            // 연산자에 따른 계산 수행
                            switch (operator) {
                                case "+":
                                    result = num1 + num2;
                                    break;
                                case "-":
                                    result = num1 - num2;
                                    break;
                                case "×":
                                    result = num1 * num2;
                                    break;
                                case "÷":
                                    if (num2 != 0) {
                                        result = num1 / num2;
                                    } else {
                                        display.setText("Error");
                                        return;
                                    }
                                    break;
                            }

                            display.setText(String.valueOf(result));  // 결과 표시
                            num1 = result;  // 결과를 num1에 저장하여 연속된 계산 가능
                        }
                    }
                });
            }

            // 기타 버튼: 기능 미구현
            else {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 기능은 나중에 구현
                    }
                });
            }

            buttonPanel.add(button);
        }

        // 버튼 패널을 중앙에 추가
        add(buttonPanel, BorderLayout.CENTER);
    }

    /**
     * 계산기 GUI를 실행하는 메인 메서드입니다.
     * 이 메서드는 GUI를 시작하고 화면에 표시합니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     *
     * @created 2024-10-17
     * @lastModified 2024-10-27
     *
     * @changelog
     * <ul>
     *   <li>2024-10-17: 최초 생성 (한승규)</li>
     *   <li>2024-10-20: 연산자 버튼 클릭 시 디스플레이에 연산자가 나타나도록 기능 추가 (한승규)</li>
     *   <li>2024-10-27: 기본적인 사칙연산 기능 추가 (한승규)</li>
     * </ul>
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
