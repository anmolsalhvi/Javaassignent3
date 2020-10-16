import java.util.Scanner;
import java.util.*;
import java.lang.Math.*;
class q1
{
    public static void main(String[] args)
    {
        int n, m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine(); // So that next input is from next line
        String temp;
        String[] crops = new String[n];
        for (int i=0;i<n;i++)
        {
            crops[i]=in.nextLine().trim();
        }
        char[][] matrix = new char[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0;j<m; j++)
            {
                matrix[i][j] = crops[i].charAt(j);
            }
        }
        char[] crop_variety = new char[26];
        for(char c='a'; c<'z'; c++)
        {
            crop_variety[c-'a'] = c;
        }
//         System.out.println(n + " " + m);
//         for(int i=0; i<n; i++)
//         {
//             for(int j=0;j<m;j++)
//             {
//                 System.out.println(matrix[i][j] + " ");
//             }
//             System.out.println();
//         }
        System.out.println(replant(matrix, 0, 0, n, m, 0, n*m, crop_variety));
    }

    public static int replant(char[][] matrix, int row_number, int col_number, int n, int m, int the_counter, int minm_count, char[] crop_variety)
    {
        Set<Character> left_upper = new HashSet<Character>();
        if(row_number!=0)
        {
            left_upper.add(matrix[row_number-1][col_number]);
        }
        if(col_number!=0)
        {
            left_upper.add(matrix[row_number][col_number-1]);
        }
        Set<Character> right_lower = new HashSet<Character>();
        if(row_number!=n-1)
        {
            right_lower.add(matrix[row_number+1][col_number]);
        }
        if(col_number!=m-1)
        {
            right_lower.add(matrix[row_number][col_number+1]);
        }
        boolean present_left_upper = false;
        if(left_upper.contains(matrix[row_number][col_number]))
        {
            present_left_upper = true;
        }
        char[][] new_matrix = new char[n][m];
        if(right_lower.contains(matrix[row_number][col_number]))
        {
            if(present_left_upper)
            {
                for(int k=0; k<26; k++)
                {
                    if(!left_upper.contains(crop_variety[k]) && !right_lower.contains(crop_variety[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0;j<m;j++)
                            {
                                new_matrix[i][j] = matrix[i][j];
                            }
                        }
                        new_matrix[row_number][col_number] = crop_variety[k];
                        if(col_number<m-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_matrix, row_number, col_number+1, n, m, the_counter+1, minm_count, crop_variety));
                        }
                        else if(row_number<n-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_matrix, row_number+1, 0, n, m, the_counter+1, minm_count, crop_variety));
                        }
                        else
                        {
                            return Math.min(the_counter+1, minm_count);
                        }
                        break;
                    }
                }
            }
            else
            {
                if(col_number<m-1)
                {
                    minm_count = Math.min(minm_count, replant(matrix, row_number, col_number+1, n, m, the_counter, minm_count, crop_variety));
                }
                else if(row_number<n-1)
                {
                    minm_count = Math.min(minm_count, replant(matrix, row_number+1, 0, n, m, the_counter, minm_count, crop_variety));
                }
                else
                {
                    return Math.min(the_counter, minm_count);
                }
                for(int k=0; k<26;k++)
                {
                    if(!left_upper.contains(crop_variety[k]) && !right_lower.contains(crop_variety[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0; j<m; j++)
                            {
                                new_matrix[i][j] = matrix[i][j];
                            }
                        }
                        new_matrix[row_number][col_number] = crop_variety[k];
                        if(col_number<m-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_matrix, row_number, col_number+1, n, m, the_counter+1, minm_count, crop_variety));
                        }
                        else if(row_number<n-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_matrix, row_number+1, 0, n, m, the_counter+1, minm_count, crop_variety));
                        }
                        else
                        {
                            return Math.min(the_counter+1, minm_count);
                        }
                        break;
                    }
                }

            }
        }
        else
        {
            if(present_left_upper)
            {
                for(int k=0; k<26;k++)
                {
                    if(!left_upper.contains(crop_variety[k]) && !right_lower.contains(crop_variety[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0;j<m;j++)
                            {
                                new_matrix[i][j] = matrix[i][j];
                            }
                        }
                        new_matrix[row_number][col_number] = crop_variety[k];
                        if(col_number<m-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_matrix, row_number, col_number+1, n, m, the_counter+1, minm_count, crop_variety));
                        }
                        else if(row_number<n-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_matrix, row_number+1, 0, n, m, the_counter+1, minm_count, crop_variety));
                        }
                        else
                        {
                            return Math.min(the_counter+1, minm_count);
                        }
                        break;
                    }
                }
            }
            else
            {
                if(col_number<m-1)
                {
                    minm_count = Math.min(minm_count, replant(matrix, row_number, col_number+1, n, m, the_counter, minm_count, crop_variety));
                }
                else if(row_number<n-1)
                {
                    minm_count = Math.min(minm_count, replant(matrix, row_number+1, 0, n, m, the_counter, minm_count, crop_variety));
                }
                else
                {
                    return Math.min(the_counter, minm_count);
                }
            }
        }
        return minm_count;
    }
}