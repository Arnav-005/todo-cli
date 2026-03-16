# Todo CLI

## Tech
- **Language:** Java 21
- **Build:** Maven
- **Storage:** File-based persistence (`tasks.txt`)

## Usage
```
add <title>     → add a new task
list            → show all tasks
done <id>       → mark a task as done
delete <id>     → delete a task
quit            → save and exit
```

## Architecture
Three classes, single responsibility each:

**`Task`** — data model. Holds id, title, status. No logic beyond its own getters/setters.

**`TaskManager`** — business logic. Owns the task list, handles all operations, validates inputs, manages file I/O.

**`Main`** — entry point and UI layer. Reads user input, parses commands, delegates to TaskManager. No business logic inside this.

## Edge Cases Handled
- `done`/`delete` on non-existent task ID
- `done`/`delete` with non-numeric argument
- `add`/`done`/`delete` with no argument
- `add` with blank/whitespace-only title
- `list` on empty task list
- Unknown commands
- Missing save file on first run
