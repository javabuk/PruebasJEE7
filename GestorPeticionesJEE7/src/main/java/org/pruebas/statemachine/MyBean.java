package org.pruebas.statemachine;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class MyBean {
	@OnTransition(target = "STATE1")
    void toState1() {
		System.out.println("Transicion a STATE1");
    }

    @OnTransition(target = "STATE2")
    void toState2() {
    	System.out.println("Transicion a STATE2");
    }
}
