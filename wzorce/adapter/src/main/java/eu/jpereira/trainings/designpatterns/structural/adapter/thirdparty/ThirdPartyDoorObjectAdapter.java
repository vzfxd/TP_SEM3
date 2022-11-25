package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorObjectAdapter implements Door {

    private final ThirdPartyDoor thirdPartyDoor;
    public ThirdPartyDoorObjectAdapter(){
        this.thirdPartyDoor = new ThirdPartyDoor();
    }
    @Override
    public void open(String code) throws IncorrectDoorCodeException {
        try {
            this.thirdPartyDoor.unlock(code);
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException(e);
        }

        try {
            this.thirdPartyDoor.setState(ThirdPartyDoor.DoorState.OPEN);
        } catch (CannotChangeStateOfLockedDoor e) {
            throw new IncorrectDoorCodeException(e);
        }
    }

    @Override
    public void close() {
        try {
            this.thirdPartyDoor.setState(ThirdPartyDoor.DoorState.CLOSED);
        } catch (CannotChangeStateOfLockedDoor e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isOpen() {
        return thirdPartyDoor.getState() == ThirdPartyDoor.DoorState.OPEN;
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {
        if(!this.testCode(oldCode)) throw new IncorrectDoorCodeException();
        if(!newCode.equals(newCodeConfirmation)) throw new CodeMismatchException();
        try {
            this.thirdPartyDoor.setNewLockCode(newCode);
        } catch (CannotChangeCodeForUnlockedDoor e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean testCode(String code) {
        try {
            this.open(code);
            this.close();
            return true;
        } catch (IncorrectDoorCodeException e) {
            return false;
        }
    }
}
