# Tic-Tac-Toe Spiel

Dieses Projekt implementiert das bekannte Tic-Tac-Toe Spiel in Java. Zwei Spieler können abwechselnd X und O auf einem 3x3 Gitter setzen. Das Spiel endet, wenn ein Spieler drei seiner Symbole in einer Reihe, Spalte oder Diagonale platziert hat, oder wenn das Spielfeld voll ist und kein Spieler gewonnen hat.

## Projektstruktur

- *Board*: Klasse, die das Spielfeld verwaltet.
- *Player*: Klasse, die die Spieler verwaltet.
- *TicTacToe*: Hauptklasse, die das Spiel steuert.

## Bedienungsanleitung

### Spielstart

Nach dem Start des Spiels wird das Spielfeld angezeigt und der aktuelle Spieler wird angezeigt.

### Zug machen

Geben Sie die Zeile (0-2) und die Spalte (0-2) für Ihren Zug ein.
Beispiel: row (0-2): 1 und column (0-2): 1

### Spielablauf

- Das Spielfeld wird nach jedem Zug aktualisiert.
- Das Spiel wechselt nach jedem gültigen Zug den Spieler.

### Spielende

Das Spiel endet, wenn ein Spieler gewinnt oder das Spielfeld voll ist.
Eine entsprechende Nachricht wird angezeigt, und das Spiel wird beendet.