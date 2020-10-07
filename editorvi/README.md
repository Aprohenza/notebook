# Deleting Text
These vi commands delete the character, word, or line you indicate.
vi stays in command mode, so any subsequent text insertions must be preceded by additional commands to enter entry mode.

### Deleting One Character
To delete one character, position the cursor over the character to be deleted and type x.

The x command also deletes the space the character occupied—when a letter is removed from the middle of a word, the remaining letters will close up, leaving no gap. You can also delete blank spaces in a line with the x command.

To delete one character before (to the left of) the cursor, type X (uppercase).

### Deleting a Word or Part of a Word
To delete a word, position the cursor at the beginning of the word and type dw. The word and the space it occupied are removed.

To delete part of a word, position the cursor on the word to the right of the part to be saved. Type dw to delete the rest of the word.

### Deleting a Line
To delete a line, position the cursor anywhere on the line and type dd. The line and the space it occupied are removed.
