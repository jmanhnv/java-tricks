package com.javatricks.java9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class Features {

	// 1.Java 9 REPL (JShell)
	private static void feature1() {
		System.out.println("Not implement...");
	}

	// 2.Factory Methods for Immutable List, Set, Map and Map.Entry
	private static void feature2() {
		// Empty List Example
		List<?> emptyImmutableList = List.of();

		// Non-Empty List Example
		List<?> nonemptyImmutableList = List.of("one", "two", "three");

		// Empty Map Example
		Map<?, ?> emptyImmutableMap = Map.of();

		// Non-Empty Map Example
		Map<?, ?> nonemptyImmutableMap = Map.of(1, "one", 2, "two", 3, "three");

		System.out.println(String.format("%d %d %d %d", emptyImmutableList.size(), nonemptyImmutableList.size(),
				emptyImmutableMap.size(), nonemptyImmutableMap.size()));
	}

	// 3.Private methods in Interfaces
	interface Card {
		private Long createCardID() {
			// Method implementation goes here.
			return 100L;
		}

		private static void displayCardDetails() {
			// Method implementation goes here.
			System.out.println("Execute Card#displayCardDetails");
		}
	}

	// 4.Java 9 Module System
	// TODO - continues

	// 5.Process API Improvements
	private static void feature5() {
		ProcessHandle currentProcess = ProcessHandle.current();
		System.out.println("Current Process Id: = " + currentProcess.pid());
	}

	// 6.Try With Resources Improvement
	private static void feature6() throws IOException {
		// Java 9 example
		BufferedReader reader1 = new BufferedReader(new FileReader("src/main/java/com/javatricks/java9/journaldev.txt"));
		try (reader1) {
			System.out.println(reader1.readLine());
		}

		// Java SE 7 example
		BufferedReader reader2 = new BufferedReader(new FileReader("src/main/java/com/javatricks/java9/journaldev.txt"));
		try (BufferedReader r = reader2) {
			System.out.println(r.readLine());
		}
	}

	// 7.CompletableFuture API Improvements
	private static void feature7() {
		Executor exe = CompletableFuture.delayedExecutor(50L, TimeUnit.SECONDS);
		exe.execute(new A());
	}

	static class A implements Runnable, Card {
		@Override
		public void run() {
			System.out.println("A is called...");
		}
	}

	public static void main(String[] args) throws Exception {
		feature1();
		feature2();
		feature5();
		feature6();
		feature7();
	}

}
