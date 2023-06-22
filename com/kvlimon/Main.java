package com.kvlimon;

import com.kvlimon.simulation.Simulation;

public class Main {
    public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Wrong number of arguments");
			return ;
		}

		Simulation simul = new Simulation(args[0]);
        simul.activateSimulation();

        return ;
    }
}
