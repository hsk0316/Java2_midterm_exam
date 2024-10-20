package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 계산기 GUI 프로그램.
 * 이 클래스는 JFrame을 확장하여 기본적인 계산기의 사용자 인터페이스(GUI)를 구성합니다.
 * 더하기, 빼기, 곱하기, 나누기 등의 연산을 위한 버튼 및 숫자 입력 버튼을 포함하고 있습니다.
 *
 * <p>이 클래스는 버튼을 클릭할 때 해당 숫자와 연산자가 디스플레이에 나타나는 기능을 제공합니다.
 * 연산 기능은 아직 구현되지 않았으며, 향후 업데이트에서 추가될 수 있습니다.</p>
 *
 * @author 한승규
 * @version 1.2.0
 * @since 2024-10-20
 *
 * @created 2024-10-17
 * @lastModified 2024-10-20
 *
 * @changelog
 * <ul>
 *   <li>2024-10-17: 최초 생성 (한승규)</li>
 *   <li>2024-10-19: 숫자 버튼 클릭 시 디스플레이에 숫자가 나타나도록 기능 추가 (한승규)</li>
 *   <li>2024-10-20: 연산자 버튼 클릭 시 디스플레이에 연산자가 나타나도록 기능 추가 (한승규)</li>
 * </ul>
 */
public class Calculator extends JFrame {

    /**
     * 사용자가 입력한 숫자 및 연산자를 표시하는 JTextField 컴포넌트입니다.
     * 숫자와 연산자 버튼을 클릭할 때마다 해당 값이 이 필드에 표시됩니다.
     */
    private JTextField display;

    /**
     * 계산기 GUI를 초기화하는 생성자입니다.
     * 프레임, 디스플레이 및 버튼들을 설정하고 레이아웃에 배치합니다.
     * 이 생성자는 계산기의 GUI 요소들을 구성하는 역할을 합니다.
     *
     * @created 2024-10-17
     * @lastModified 2024-10-20
     * @see <a href="https://limunosekai.github.io/java/2021/01/04/java-day-20/">Java Day 20</a>
     * @changelog
     * <ul>
     *   <li>2024-10-17: 최초 생성 (한승규)</li>
     *   <li>2024-10-19: 숫자 버튼 클릭 시 디스플레이에 숫자가 나타나도록 기능 추가 (한승규)</li>
     *   <li>2024-10-20: 연산자 버튼 클릭 시 디스플레이에 연산자가 나타나도록 기능 추가 (한승규)</li>
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

        // 버튼 배열 (각 버튼의 텍스트)
        String[] buttons = {
                "←", "CE", "C", "÷",
                "7", "8", "9", "×",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", "+/-", ".", "="
        };

        // 버튼 추가 및 이벤트 리스너 설정
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));

            // 숫자 및 연산자 버튼에 이벤트 추가
            if ("0123456789".contains(text) || "÷×-+".contains(text)) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 현재 텍스트가 "0"인 경우에는 새로운 숫자 또는 연산자로 교체, 그렇지 않으면 이어서 추가
                        if (display.getText().equals("0")) {
                            display.setText(text);
                        } else {
                            display.setText(display.getText() + text);
                        }
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
     * @lastModified 2024-10-20
     *
     * @changelog
     * <ul>
     *   <li>2024-10-17: 최초 생성 (한승규)</li>
     *   <li>2024-10-19: 숫자 버튼 클릭 시 디스플레이에 숫자가 나타나도록 기능 추가 (한승규)</li>
     *   <li>2024-10-20: 연산자 버튼 클릭 시 디스플레이에 연산자가 나타나도록 기능 추가 (한승규)</li>
     * </ul>
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}

