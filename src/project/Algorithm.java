package project;


/*
 *Dijkstra�����·���㷨 
 */

public class Algorithm {

    public static final int M = -1;
    static int[][] map = {
        { 0, 8, 1, 2, M },
        { 8, 0, M, 3, M },
        { 1, M, 0, 2, 3 },
        { 2, 3, 2, 0, M },
        { M, M, 3, M, 0 }
    };
    static int n =map.length;       //����ĸ���
    static int[] shortest = new int[n];  //��Ŵ�start�������ڵ�����·��
    static boolean[] visited = new boolean[n]; //��ǵ�ǰ�ö�������·���Ƿ��Ѿ������true��ʾ�Ѿ����

    public static void main(String[] args) {
        int orig = 0; //��ʼ��
        //Ѱ�����·��
        int[] shortPath = dijkstra_alg(orig);

        if(shortPath == null){
            return;
        }

        for(int i=0; i< shortPath.length; i++){
            System.out.println("��" + (orig) + "������" + (i) + "����̾���Ϊ��"+ shortPath[i]);
            }
    }

    private static int[] dijkstra_alg(int orig) {
        // TODO Auto-generated method stub
        // ��ʼ������һ���������
        shortest[orig] = 0;
        visited[orig] = true;

        //��Ŵ�start���������ڵ�����·��
        String[] path = new String[n];
        for(int i = 0; i < n; i++){
            path[i] = new String(orig + "--->" + i);
        }
        for(int count = 0; count != n-1; count ++)
        {
            //ѡ��һ�������ʼ���������Ϊ��Ƕ���
            int k = M;
            int min = M;
            for(int i =0; i< n ; i++)//����ÿһ������
            {
                if( !visited[i] && map[orig][i] != M) //����ö���δ������������orig����
                {
                    if(min == -1 || min > map[orig][i]) //�ҵ���orig����ĵ�
                    {
                        min = map[orig][i];
                        k = i;
                    }
                }
            }
            //��ȷ��ͼ���ɵľ��󲻿��ܳ���K== M�����
            if(k == M)
            {
                System.out.println("the input map matrix is wrong!");
                return null;
            }
            shortest[k] = min;
            visited[k] = true;
            //��kΪ���ĵ㣬����oirg��δ���ʵ�ľ���
            for (int i = 0; i < n; i++)
            {
                if (!visited[i] && map[k][i] != M)
                {
                    int callen = min + map[k][i];
                    if (map[orig][i] == M || map[orig][i] > callen)
                    {
                        map[orig][i] = callen;
                        path[i] = path[k] + "--->" + i;
                    }
                }
            }
        }

        for(int i=0;i<n;i++)  
               System.out.println("��"+orig+"������"+i+"�����·��Ϊ��"+path[i]);    
        System.out.println("=====================================");

        return shortest;
    }
}
