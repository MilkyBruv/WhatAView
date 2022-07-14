package main.controller;

import org.lwjgl.input.Controllers;

import main.GamePanel;

import org.lwjgl.input.Controller;

public class PlayerController {
    
    private Controller controller;
    private ControllerData controllerData = new ControllerData();
    private GamePanel gp;

    public PlayerController(int contNum, GamePanel gp) {

        this.gp = gp;

        if (this.gp.PLAYMODE.equals("c")) {

            this.controller = Controllers.getController(contNum);

        }

    }



    public boolean isButtonPressed(String button) {

        this.controller.poll();

        if (this.controller.isButtonPressed(controllerData.codes.get(button))) {

            return true;

        } else {

            return false;

        }

    }



    public boolean isAxisMoved(String axis) {

        this.controller.poll();

        // Up / Down

        if (axis.equals("up")) {

            if (this.controller.getAxisValue(2) <= -0.3f) {

                return true;

            } else {

                return false;

            }

        }

        if (axis.equals("down")) {

            if (this.controller.getAxisValue(2) >= 0.3f) {

                return true;

            } else {

                return false;

            }

        }

        // Left / Right

        if (axis.equals("left")) {

            if (this.controller.getAxisValue(3) <= -0.3f) {

                return true;

            } else {

                return false;

            }

        }

        if (axis.equals("right")) {

            if (this.controller.getAxisValue(3) >= 0.3f) {

                return true;

            } else {

                return false;

            }

        }

        else {

            return false;

        }

    }


    
    public boolean isAxisMoved(String axis, float val) {

        this.controller.poll();

        // Up / Down

        if (axis.equals("up")) {

            if (this.controller.getAxisValue(2) <= -val) {

                return true;

            } else {

                return false;

            }

        }

        if (axis.equals("down")) {

            if (this.controller.getAxisValue(2) >= val) {

                return true;

            } else {

                return false;

            }

        }

        // Left / Right

        if (axis.equals("left")) {

            if (this.controller.getAxisValue(3) <= -val) {

                return true;

            } else {

                return false;

            }

        }

        if (axis.equals("right")) {

            if (this.controller.getAxisValue(3) >= val) {

                return true;

            } else {

                return false;

            }

        }

        else {

            return false;

        }

    }

}
