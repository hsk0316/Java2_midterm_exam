package calculator;

import javax.swing.*;
import java.awt.*;

/**
 * 계산기 프로그램.
 * 이 클래스는 JFrame을 확장하여 계산기의 기본 UI를 구성합니다.
 * 더하기, 빼기, 곱하기, 나누기 등의 연산 버튼을 포함한 계산기의 GUI를 구현합니다.
 *
 * @author 한승규
 * @version 1.0
 * @since 2024-10-17
 *
 * @created 2024-10-17
 * @lastModified 2024-10-17
 *
 * @changelog
 * <ul>
 *   <li>2024-10-17: 최초 생성 (한승규)</li>
 * </ul>
 */
public class Calculator extends JFrame {

    private JTextField display;

    /**
     * 계산기 GUI를 초기화하는 생성자.
     * 프레임, 디스플레이, 버튼을 설정하고 배치합니다.
     *
     * @created 2024-10-17
     * @lastModified 2024-10-17
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
            buttonPanel.add(button);
        }

        // 버튼 패널을 중앙에 추가
        add(buttonPanel, BorderLayout.CENTER);
    }

    /**
     * 계산기 GUI를 실행하는 메인 메서드.
     *
     * @param args 명령행 인수 (사용하지 않음)
     *
     * @created 2024-10-17
     * @lastModified 2024-10-17
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
