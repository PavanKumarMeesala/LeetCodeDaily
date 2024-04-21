class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for(int[] edge : edges)
        {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        return DFS(source, destination, graph, visited);
    }

    private boolean DFS(int node, int destination, HashMap<Integer, ArrayList<Integer>> graph, Set<Integer> visited)
    {
        if(node == destination)
        {
            return true;
        }

        visited.add(node);
        for(int neighbor : graph.getOrDefault(node, new ArrayList<>()))
        {
            if(!visited.contains(neighbor))
            {
                if(DFS(neighbor, destination, graph, visited))
                {
                    return true;
                }
            }
        }

        return false;
    }
}