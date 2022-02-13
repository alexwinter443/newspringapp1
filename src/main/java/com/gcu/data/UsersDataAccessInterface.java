package com.gcu.data;

/*
 * Elijah Olmos and Alex Vergara
 * Milestone
 * 11/29/2021
 */

public interface UsersDataAccessInterface<T> {
	public T findByUsername(String username);
}
