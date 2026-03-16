# Todo CLI

## Tech
* **Language:** Java 21
* **Build:** Maven
* **Storage:** In-memory (ArrayList), no persistence yet

## Features
* Add a task with a title
* List all tasks with status indicators `[X]` / `[ ]`
* Mark a task as done by ID
* Delete a task by ID
* Empty state messaging on list
* exit with quit

## Architecture
Three classes, single responsibility each:
* **Task** — data model. Holds id, title, status. No logic beyond its own getters/setters.
* **TaskManager** — business logic. Owns the task list, handles all operations on it, validates inputs.
* **Main** — entry point and UI layer. Reads user input, parses commands, delegates to TaskManager. No business logic inside this.

## Edge Cases Handled
* `done`/`delete` on non-existent task ID
* `done`/`delete` with non-numeric argument
* `add`/`done`/`delete` with no argument
* `add` with blank/whitespace-only title
* `list` on empty task list
* Unknown commands
