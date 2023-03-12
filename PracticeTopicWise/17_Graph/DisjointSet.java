class DisjointSet {
    public final List<Integer> rank = new ArrayList<>();
    public final List<Integer> size = new ArrayList<>();
    public final List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }

    public int findWithoutPathCompression(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        return findWithoutPathCompression(parent.get(node));
    }

    public int findWithPathCompression(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int ultimateParent = findWithPathCompression(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    public void unionByRank(int u, int v) {
        int ultimateParentU = findWithPathCompression(u);
        int ultimateParentV = findWithPathCompression(v);

        if (ultimateParentU == ultimateParentV) {
            return;
        }

        if (rank.get(ultimateParentU) < rank.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV);
        } else if (rank.get(ultimateParentU) > rank.get(ultimateParentV)) {
            parent.set(ultimateParentV, ultimateParentU);
        } else {
            parent.set(ultimateParentV, ultimateParentU);
            int rankU = rank.get(ultimateParentU);
            rank.set(ultimateParentU, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ultimateParentU = findWithPathCompression(u);
        int ultimateParentV = findWithPathCompression(v);

        if (ultimateParentU == ultimateParentV) {
            return;
        }

        if (size.get(ultimateParentU) < size.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV);
            int sizeU = size.get(ultimateParentU);
            int sizeV = size.get(ultimateParentV);
            size.set(ultimateParentV, sizeU + sizeV);
        } else {
            parent.set(ultimateParentV, ultimateParentU);
            int sizeU = size.get(ultimateParentU);
            int sizeV = size.get(ultimateParentV);
            size.set(ultimateParentU, sizeU + sizeV);
        }
    }
}
