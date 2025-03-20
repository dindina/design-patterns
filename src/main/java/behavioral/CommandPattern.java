package behavioral;


// Command Interface
interface Command {
    void execute();
    void undo(); // Optional: For undoable commands
}

class TurnOnCommand implements Command {
    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}
// Receiver (The object that performs the actual action)
class Light {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("Light is ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Light is OFF");
    }

    public boolean isOn() {
        return isOn;
    }
}

// Concrete Command (Turn Off)
class TurnOffCommand implements Command {
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

// Invoker (The object that triggers the command)
class RemoteControl {
    private Command command;
    private Command previousCommand; // For undo

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
            previousCommand = command; // Store for undo
        }
    }

    public void pressUndoButton() {
        if (previousCommand != null) {
            previousCommand.undo();
            previousCommand = null; // Clear previous command after undo
        }
    }
}
public class CommandPattern {

    public static void main(String[] args) {
        Light light = new Light();

        TurnOnCommand turnOnCommand = new TurnOnCommand(light);
        TurnOffCommand turnOffCommand = new TurnOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOnCommand);
        remote.pressButton(); // Light is ON

        remote.setCommand(turnOffCommand);
        remote.pressButton(); // Light is OFF

        remote.setCommand(turnOnCommand);
        remote.pressButton(); // light is ON

        remote.pressUndoButton(); // light is OFF

        remote.pressUndoButton(); // No undo, as previous command was cleared.

    }
}
