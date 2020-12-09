package lc.contest.Two18;

public class One
{
    public static String interpret(String command)
    {
        if(command == null || command.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();
        int pos = 0;
        while(pos < command.length())
        {
            if(command.charAt(pos) == 'G')
            {
                sb.append('G');
                pos++;
            }
            else if(command.charAt(pos) == '(')
            {
                if(command.charAt(pos + 1) == ')')
                {
                    sb.append('o');
                    pos += 2;
                }
                else
                {
                    sb.append("al");
                    pos += 4;
                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args)
    {
        String command = "G()()()()(al)";
        String ret = interpret(command);
        System.out.println(ret);
    }
}
