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

# Copying and Moving Text — Yank, Delete, and Put
Many word processors allow you to “copy and paste” and “cut and paste” lines of text. The vi editor also includes these features. The vi command-mode equivalent of “copy and paste” is yank and put. The equivalent of “cut and paste” is delete and put.

The methods for copying or moving small blocks of text in vi involves the use of a combination of the yank, delete, and put commands.

### Copying Lines
Copying a line requires two commands: yy or Y (“yank”) and either p (“put below”) or P (“put above”). Note that Y does the same thing as yy.

To yank one line, follow these steps.

  1. Position the cursor anywhere on the line you want to yank.

  2. Type yy.

  3. Move the cursor to the line above where you want to put (copy) the yanked line.

  4. Type p.

  A copy of the yanked line appears in a new line below the cursor.

  To place the yanked line in a new line above the cursor, type P.

The yy command works well with a count: to yank 11 lines, for example, type 11yy. Eleven lines, counting down from the cursor, are yanked, and vi indicates this with a message at the bottom of the screen: 11 lines yanked.

You can also use the P or p commands immediately after any of the deletion commands discussed earlier. This action puts the text you deleted above or below the cursor, respectively.

## Caution
Use only cursor-moving commands between yanking or deleting and putting. If you delete or yank any other text before putting the new text in place, the lines you yanked or deleted are lost.

# Moving Lines
Moving lines also requires two commands: dd (“delete”) and either p or P.

To move one line, position the cursor anywhere on the line and type dd. For example, to delete 5 lines, type 5dd.

Next, move the cursor to the line above where you want the deleted line reinserted and type p. This inserts the text on a new line below the cursor.

Alternatively, you can put the deleted line above the cursor by typing P.
