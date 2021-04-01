package com.mockserver.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MockLiveController {

    static List<String> liveMatchList = new ArrayList<>();
    static Map<String, String> Situations = new HashMap<>();
    static Map<String, String> Situations_running = new HashMap<>();
    private int moves;

    static {
        liveMatchList.add("{\n" +
                "            \"name\": \"TEST_GAME_1\",\n" +
                "            \"broadcast_time\": \"2021-04-01 9:00\",\n" +
                "            \"komi\": \"6.5\",\n" +
                "            \"handicap\": \"0\",\n" +
                "            \"blackPlayer\": \"晓晓\",\n" +
                "            \"whitePlayer\": \"天天\",\n" +
                "            \"url\": \"/golive/66190\",\n" +
                "            \"id\": 66190,\n" +
                "            \"po\": 12000\n" +
                "        }");
        liveMatchList.add("{\n" +
                "            \"name\": \"TEST_GAME_2\",\n" +
                "            \"broadcast_time\": \"2021-03-31 12:00\",\n" +
                "            \"komi\": \"7.5\",\n" +
                "            \"handicap\": \"0\",\n" +
                "            \"blackPlayer\": \"AA\",\n" +
                "            \"whitePlayer\": \"BB\",\n" +
                "            \"url\": \"/golive/66187\",\n" +
                "            \"id\": 66187,\n" +
                "            \"po\": 12000\n" +
                "        }");

        Situations.put("66187", "{" +
                "    \"Status\":1200," +
                "    \"Result\":" +
                "        {" +
                "            \"sgf\":\"(;GM[1]FF[4]CA[UTF-8]SO[弈客围棋]RU[cn]KM[7.5]HA[0]AP[弈客围棋]SZ[19]PB[AA]PW[BB];B[pd];W[dd];B[pq];W[dq];B[co];W[qc];B[qd];W[pc];B[od];W[nb];B[ep];W[eq];B[fp];W[gq];B[cf];W[ch];B[qn];W[dk];B[mc];W[cc];B[ei];W[di];B[ee];W[fd];B[eh];W[ej];B[gp];W[hq];B[hp];W[iq];B[ip];W[jq];B[cj];W[ck];B[fj];W[fk];B[gk];W[gj];B[fi];W[bj];B[fl];W[ek];B[hj];W[nc];B[nd];W[md];B[kd];W[ld];B[lc];W[ke];B[jd];W[je];B[id];W[kc];B[kb];W[lb];B[jc];W[mb];B[kc];W[gi];B[gh];W[hi];B[hh];W[ii];B[ih];W[ji];B[jh];W[ki];B[kh];W[li];B[hk];W[lh];B[lg];W[mg];B[mf];W[ng];B[nf];W[pj];B[oh];W[og];B[ph];W[ni];B[rd];W[rc];B[nh];W[mh];B[qg];W[jl];B[jp];W[ml];B[fq];W[fr];B[gr];W[dr];B[kq];W[kr];B[lr];W[jr];B[lq];W[fe];B[ff];W[gc];B[ge];W[ef];B[df];W[gf];B[eg];W[he];B[ie];W[if];B[jf];W[om];B[sc];W[sb];B[sd];W[qb];B[bd];W[bc];B[fs];W[er];B[ql];W[pl];B[bl];W[dm];B[cm];W[dn];B[dp];W[cn];B[bn];W[cl];B[bm];W[fm];B[gm];W[el];B[qk];W[gl];B[hm];W[oo];B[po];W[oq];B[op];W[np];B[pp];W[nq];B[on];W[nn];B[no];W[mo];B[mn];W[oo];B[ed];W[ec];B[no];W[lf];B[kg];W[oo];B[hr];W[ir];B[no];W[ne];B[nm];W[of];B[hf];W[ln];B[lo];W[mm];B[mp];W[qi];B[rh];W[ri];B[si];W[sj];B[sh];W[qh];B[rg];W[hg];B[gg];W[pg];B[rj];W[qf];B[rf];W[gd];B[hb];W[gb];B[ig];W[km];B[bq];W[hl];B[il];W[fl];B[im];W[ik];B[kn];W[lm];B[jm];W[kk];B[ga];W[fa];B[ha];W[fb];B[qj];W[pi];B[oc];W[ob];B[kf];W[me];B[jk];W[jj];B[fn];W[jn];B[ko];W[nl];B[cr];W[cq];B[br];W[qe];B[re];W[nn];B[pk];W[mo];B[oo];W[ok];B[ks];W[hs];B[pm];W[en];B[fo];W[bf];B[bi];W[ci];B[bk];W[aj];B[ak];W[dj];B[ai];W[cj];B[bg];W[be];B[ce];W[cd];B[af];W[ad];B[cg];W[hc];B[ib];W[cp];B[bp];W[ol];B[le];W[ke];B[hf];W[bh];B[do];W[ah];B[ag];W[gs];B[js];W[ka];B[ja];W[la])\"," +
                "            \"result\":\"\"," +
                "            \"status\":2," +
                "            \"id\":66113," +
                "            \"delete_flag\":0" +
                "        }," +
                "        \"Message\":\"\"" +
                "}");
        Situations.put("66190", "{\n" +
                "    \"Status\": 1200,\n" +
                "    \"Result\": {\n" +
                "        \"sgf\": \"(;CA[utf-8]AP[abacus]SZ[19]PB[晓晓]PW[天天];B[pd];W[pp];B[dd];W[cp];B[eq];W[dq];B[ep];W[cn];B[nq];W[iq];B[qn];W[pn];B[pm])\",\n" +
                "        \"result\": \"\"," +
                "        \"status\": 2,\n" +
                "        \"id\": 66199,\n" +
                "        \"delete_flag\": 0\n" +
                "    },\n" +
                "    \"Message\": \"\"\n" +
                "}");
        Situations_running.put("66190", "{\n" +
                "    \"Status\": 1200,\n" +
                "    \"Result\": {\n" +
                "        \"sgf\": \"(;CA[utf-8]AP[abacus]SZ[19]PB[晓晓]PW[天天])\",\n" +
                "        \"result\": \"\"," +
                "        \"status\": 2,\n" +
                "        \"id\": 66199,\n" +
                "        \"delete_flag\": 0\n" +
                "    },\n" +
                "    \"Message\": \"\"\n" +
                "}");
        Situations_running.put("66187", "{" +
                "    \"Status\":1200," +
                "    \"Result\":" +
                "        {" +
                "            \"sgf\":\"(;GM[1]FF[4]CA[UTF-8]SO[弈客围棋]RU[cn]KM[7.5]HA[0]AP[弈客围棋]SZ[19]PB[AA]PW[BB])\"," +
                "            \"result\":\"\"," +
                "            \"status\":2," +
                "            \"id\":66113," +
                "            \"delete_flag\":0" +
                "        }," +
                "        \"Message\":\"\"" +
                "}");
    }

    @GetMapping("mockserver/active")
    public Object getAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"Status\": 1200");
        sb.append("\"Result\":[");
        for(String match: liveMatchList) {
            sb.append(match).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("],\"message\": \"\"}");
        return sb.toString();
    }

    @GetMapping("mockserver/active/{liveId}")
    public Object getByLiveID(@PathVariable("liveId") String liveId) {
        return Situations_running.get(liveId);
    }

    @Scheduled(fixedRate = 1000)
    public void fixSituation() {
        for(Map.Entry<String, String> entry: Situations.entrySet()) {
            String liveId = entry.getKey();
            String situation = entry.getValue();
            String[] sp = situation.split(",|:");
            String sgf = sp[4];
            String[] st = sgf.split(";");
            if(moves < st.length) {
                Situations_running.put(liveId, addMove(Situations_running.get(liveId), st[moves]));
            }
            int maxMoves = 70;
            if(moves == maxMoves) {
                Situations_running.put(liveId, endLive(Situations_running.get(liveId)));
            }
        }
        moves++;
    }

    public String addMove(String situation, String move) {
        String sgf = situation.split(",|:")[4];
        StringBuilder sb = new StringBuilder(sgf);
        sb.delete(sb.length() - 2, sb.length());
        sb.append(";").append(move).append("\")");
        return situation.replace(sgf, sb.toString());
    }

    public String endLive(String situation) {
        return situation.replace("result:\"\",status:2", "result:\"B+R\",status:3");
    }
}
