package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorAdapter extends ThirdPartyDoor implements Door {
    @Override
    public void open(String code) throws IncorrectDoorCodeException {
        try {
            unlock(code);
        }catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException(e);
        }

        try {
            setState(DoorState.OPEN);
        } catch (CannotChangeStateOfLockedDoor e) {
            throw new IncorrectDoorCodeException(e);
        }

    }

    @Override
    public void close(){
        try {
            setState(DoorState.CLOSED);
        } catch (CannotChangeStateOfLockedDoor e) {
            System.out.println("Door is already closed");
        }
    }

    @Override
    public boolean isOpen() {
        return super.getState() == DoorState.OPEN;
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {

        if(!this.testCode(oldCode)) throw new IncorrectDoorCodeException();
        if(!newCode.equals(newCodeConfirmation)) throw new CodeMismatchException();

        try {
            setNewLockCode(newCode);
        } catch (CannotChangeCodeForUnlockedDoor e) {
            throw new RuntimeException();
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
