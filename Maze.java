// Time Complexity : O(mXn)
// Space Complexity : O(mXn)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze.length==0 || maze==null)
        {
            return false;
        }
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start[0],start[1]});
        maze[start[0]][start[1]]=2;

        while(!q.isEmpty())
        {
            int []curr=q.poll();
            for(int []dir:dirs)
            {
                int i=curr[0];
                int j=curr[1];
                while(i< m && j<n && i>=0 && j>=0 && maze[i][j]!=1)
                {
                    i=i+dir[0];
                    j=j+dir[1];
                }
                i=i-dir[0];
                j=j-dir[1];
                if(maze[i][j]==0)
                {
                    if(i==destination[0] && j==destination[1])
                    {
                        return true;
                    }
                    maze[i][j]=2;
                    q.add(new int[] {i,j});
                }
            }
        }

        return false;

    }
}