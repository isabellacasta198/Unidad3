public Cell fixTarget(Cell initialTarget) {
    Queue<Cell> queue = new LinkedList<>();
    HashSet<Cell> visited = new HashSet<>();

    queue.add(initialTarget);
    visited.add(initialTarget);

    while (!queue.isEmpty()) {
        Cell current = queue.poll();

        // Si encontramos una celda transitable, la devolvemos
        if (game.getGameSpace(current.getX(), current.getY()) == 0) {
            return current;
        }

        // Recorremos sus vecinos
        for (Cell neighbor : game.getNeighbors(current)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.add(neighbor);
            }
        }
    }

    // Si no encontramos ninguna celda libre
    return null;
}
//Busca una celda vecina no bloqueada (sin obstáculo) cercana al objetivo original y la devuelve como nuevo objetivo
