package com.gcu.data;

/*
 * Elijah Olmos and Alex Vergara
 * Milestone
 * 01/29/2022
 */

public interface UsersDataAccessInterface<T> {
	public T findByUsername(String username);
}
