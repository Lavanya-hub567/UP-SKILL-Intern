import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BugTrackingSystemGUI extends JFrame {
    private List<Bug> bugs;
    private DefaultListModel<Bug> bugListModel;
    private JList<Bug> bugList;

    public BugTrackingSystemGUI() {
        bugs = new ArrayList<>();
        bugListModel = new DefaultListModel<>();
        bugList = new JList<>(bugListModel);

        setTitle("Bug Tracking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addButton = new JButton("Add Bug");
        JButton resolveButton = new JButton("Resolve Selected Bug");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = JOptionPane.showInputDialog("Enter bug description:");
                if (description != null && !description.isEmpty()) {
                    Bug bug = new Bug(bugs.size() + 1, description);
                    bugs.add(bug);
                    bugListModel.addElement(bug);
                }
            }
        });

        resolveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bug selectedBug = bugList.getSelectedValue();
                if (selectedBug != null && !selectedBug.isResolved()) {
                    selectedBug.resolve();
                    bugList.repaint();
                }
            }
        });

        panel.add(addButton, BorderLayout.NORTH);
        panel.add(new JScrollPane(bugList), BorderLayout.CENTER);
        panel.add(resolveButton, BorderLayout.SOUTH);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BugTrackingSystemGUI bugTrackingSystemGUI = new BugTrackingSystemGUI();
                bugTrackingSystemGUI.setVisible(true);
            }
        });
    }
}
